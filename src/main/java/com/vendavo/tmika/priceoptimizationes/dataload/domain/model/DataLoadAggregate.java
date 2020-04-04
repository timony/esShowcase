package com.vendavo.tmika.priceoptimizationes.dataload.domain.model;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.StartDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadRequestedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadStatusChangedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Data
@Aggregate
@NoArgsConstructor
public class DataLoadAggregate {

    @AggregateIdentifier
    private String id;

    private String file;

    private DataLoadStatus status;

    @CommandHandler
    public DataLoadAggregate(UploadDataLoadCommand cmd) {
        Assert.notNull(cmd.getFile(), "File cannot be null");
        apply(DataLoadRequestedEvent.from(cmd))
                .andThenApply(() -> DataLoadStatusChangedEvent.builder()
                        .id(cmd.getId())
                        .newStatus(DataLoadStatus.PENDING).build());
    }

    @EventSourcingHandler
    public void on(DataLoadRequestedEvent event) {
        this.id = event.getId();
        this.file = event.getFile();
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(DataLoadStatusChangedEvent event) {
        this.status = event.getNewStatus();
    }

    @CommandHandler
    public void handle(StartDataLoadCommand cmd) {
        apply(DataLoadStatusChangedEvent.builder()
                .id(cmd.getId())
                .newStatus(DataLoadStatus.RUNNING)
                .build());
    }
}
