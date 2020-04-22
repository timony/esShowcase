package com.vendavo.tmika.priceoptimizationes.dataload.domain.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class DataLoadStartedEvent extends DataLoadStatusChangedEvent {
}
