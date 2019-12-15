package com.vendavo.tmika.priceoptimizationes.load.domain.event;

import com.vendavo.tmika.priceoptimizationes.load.domain.command.UploadDataLoadCommand;
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

    public static DataLoadRequestedEvent from(UploadDataLoadCommand cmd) {
        return DataLoadRequestedEvent.builder()
                .id(cmd.getId())
                .file(cmd.getFile())
                .build();
    }
}
