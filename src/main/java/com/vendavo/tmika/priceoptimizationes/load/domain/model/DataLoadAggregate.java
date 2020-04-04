package com.vendavo.tmika.priceoptimizationes.load.domain.model;

import com.vendavo.tmika.priceoptimizationes.load.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadRequestedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

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
        apply(DataLoadRequestedEvent.from(cmd));
    }

    @EventSourcingHandler
    public void on(DataLoadRequestedEvent event, @Timestamp Instant time) {
        this.id = event.getId();
        this.file = event.getFile();
        this.status = event.getStatus();
    }
}
