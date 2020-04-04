package com.vendavo.tmika.priceoptimizationes.load.domain.event;

import com.vendavo.tmika.priceoptimizationes.load.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.load.domain.model.DataLoadStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

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
