package com.vendavo.tmika.priceoptimizationes.dataload.projection.stats;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.stats.repository.DailyLoadedStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DailyLoadedStatisticsProjection {

    @Autowired
    DailyLoadedStatisticsRepository repository;

}

