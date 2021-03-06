package com.vendavo.tmika.priceoptimizationes.dataload.projection.base.query.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindByIdQuery {

    String id;
}
