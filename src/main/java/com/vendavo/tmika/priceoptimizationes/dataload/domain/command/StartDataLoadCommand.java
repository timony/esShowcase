package com.vendavo.tmika.priceoptimizationes.dataload.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartDataLoadCommand {

    @TargetAggregateIdentifier
    private String id;

}
