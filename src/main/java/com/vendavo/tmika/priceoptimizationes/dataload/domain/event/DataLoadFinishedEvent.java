package com.vendavo.tmika.priceoptimizationes.dataload.domain.event;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.FinishDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadResult;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DataLoadFinishedEvent extends DataLoadStatusChangedEvent {

    private DataLoadResult result;

    private Long recordsLoaded;

    public static DataLoadFinishedEvent from(FinishDataLoadCommand cmd) {
        return DataLoadFinishedEvent.builder()
                .id(cmd.getId())
                .result(cmd.getResult())
                .recordsLoaded(cmd.getRecordsLoaded())
                .newStatus(DataLoadStatus.FINISHED)
                .build();
    }
}
