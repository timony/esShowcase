package com.vendavo.tmika.priceoptimizationes.load.domain.event;

import com.vendavo.tmika.priceoptimizationes.load.domain.model.DataLoadStatus;
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
}
