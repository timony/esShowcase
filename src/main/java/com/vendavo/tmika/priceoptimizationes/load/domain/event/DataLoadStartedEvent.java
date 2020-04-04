package com.vendavo.tmika.priceoptimizationes.load.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class DataLoadStartedEvent extends DataLoadEvent {

}
