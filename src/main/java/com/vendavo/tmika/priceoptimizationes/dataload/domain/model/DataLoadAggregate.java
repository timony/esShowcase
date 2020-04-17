package com.vendavo.tmika.priceoptimizationes.dataload.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

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

}
