package com.vendavo.tmika.priceoptimizationes.dataload.domain.event;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.ChangeDataLoadStatusCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DataLoadStatusChangedEvent extends DataLoadEvent {

    private DataLoadStatus newStatus;

    public static DataLoadStatusChangedEvent from(ChangeDataLoadStatusCommand cmd) {
        return DataLoadStatusChangedEvent.builder()
                .id(cmd.getId())
                .newStatus(cmd.getNewStatus())
                .build();
    }
}
