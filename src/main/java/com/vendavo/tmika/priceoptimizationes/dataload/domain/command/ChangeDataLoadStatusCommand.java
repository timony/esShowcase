package com.vendavo.tmika.priceoptimizationes.dataload.domain.command;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeDataLoadStatusCommand {

    @TargetAggregateIdentifier
    private String id;

    private DataLoadStatus newStatus;
}
