package com.vendavo.tmika.priceoptimizationes.dataload.domain.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public abstract class DataLoadEvent {

    private String id;
}
