package com.vendavo.tmika.priceoptimizationes.dataload.domain.event;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AsyncRunningFinishedEvent extends DataLoadEvent {

    private DataLoadResult result;

    private Long recordsLoaded;
}
