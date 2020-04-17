package com.vendavo.tmika.priceoptimizationes.dataload.domain.model;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.ChangeDataLoadStatusCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.FinishDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadFinishedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadStartedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadStatusChangedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadUploadedEvent;
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

    private DataLoadResult result;

    private long recordsLoaded;

    @CommandHandler
    public DataLoadAggregate(UploadDataLoadCommand cmd) {
        Assert.notNull(cmd.getFile(), "File cannot be null");
        apply(DataLoadUploadedEvent.from(cmd))
                .andThenApply(() -> DataLoadStartedEvent.builder()
                        .id(cmd.getId())
                        .newStatus(DataLoadStatus.PENDING)
                        .build());
    }

    @EventSourcingHandler
    public void on(DataLoadUploadedEvent event) {
        this.id = event.getId();
        this.file = event.getFile();
        this.status = event.getNewStatus();
    }

    @CommandHandler
    public void handle(ChangeDataLoadStatusCommand cmd) {
        apply(DataLoadStatusChangedEvent.from(cmd));
    }

    @EventSourcingHandler
    public void on(DataLoadStatusChangedEvent event) {
        this.status = event.getNewStatus();
    }

    @CommandHandler
    public void handle(FinishDataLoadCommand cmd) {
        apply(DataLoadFinishedEvent.from(cmd));
    }

    @EventSourcingHandler
    public void on(DataLoadFinishedEvent event) {
        this.result = event.getResult();
        this.status = event.getNewStatus();
    }
}
