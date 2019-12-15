package com.vendavo.tmika.priceoptimizationes.load.domain.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public abstract class DataLoadEvent {

    private String id;
}
