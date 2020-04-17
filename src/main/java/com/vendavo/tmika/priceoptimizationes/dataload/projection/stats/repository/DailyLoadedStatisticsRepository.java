package com.vendavo.tmika.priceoptimizationes.dataload.projection.stats.repository;


import com.vendavo.tmika.priceoptimizationes.dataload.projection.stats.model.DailyLoadedStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyLoadedStatisticsRepository extends CrudRepository<DailyLoadedStatistics, String> {
}
