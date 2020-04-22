package com.vendavo.tmika.priceoptimizationes.dataload.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadDataLoadCommand {

    @TargetAggregateIdentifier
    private String id;

    private String file;
}
