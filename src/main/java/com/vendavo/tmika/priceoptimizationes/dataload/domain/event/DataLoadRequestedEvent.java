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
public class DataLoadRequestedEvent extends DataLoadEvent {

    private String file;

    private DataLoadStatus status;

    public static DataLoadRequestedEvent from(UploadDataLoadCommand cmd) {
        return DataLoadRequestedEvent.builder()
                .id(cmd.getId())
                .file(cmd.getFile())
                .status(DataLoadStatus.NEW)
                .build();
    }
}
