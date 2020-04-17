package com.vendavo.tmika.priceoptimizationes.dataload.projection.stats.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyLoadedStatistics {

    @Id
    private String id;

    private Long loadsCount = 0L;

    private Long recordsCount = 0L;
}
