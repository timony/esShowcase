package com.vendavo.tmika.priceoptimizationes.load.domain.model;

import com.vendavo.tmika.priceoptimizationes.load.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadRequestedEvent;
import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadStatusChangedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.time.Instant;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Data
@Aggregate
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
}
