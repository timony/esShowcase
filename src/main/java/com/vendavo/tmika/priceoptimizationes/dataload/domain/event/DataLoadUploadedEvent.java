package com.vendavo.tmika.priceoptimizationes.dataload.domain.event;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataLoadUploadedEvent extends DataLoadStatusChangedEvent {

    private String file;

    public static DataLoadUploadedEvent from(UploadDataLoadCommand cmd) {
        return DataLoadUploadedEvent.builder()
                .id(cmd.getId())
                .file(cmd.getFile())
                .newStatus(DataLoadStatus.NEW)
                .build();
    }
}
