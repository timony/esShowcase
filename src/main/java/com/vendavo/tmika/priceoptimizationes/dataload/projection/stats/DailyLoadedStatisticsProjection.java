package com.vendavo.tmika.priceoptimizationes.dataload.projection.stats;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadFinishedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadStartedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.stats.model.DailyLoadedStatistics;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.stats.repository.DailyLoadedStatisticsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Transactional
public class DailyLoadedStatisticsProjection {

    @Autowired
    DailyLoadedStatisticsRepository repository;

    @EventHandler
    public void on(DataLoadStartedEvent event, @Timestamp Instant time) {
        ZonedDateTime zonedDateTime = time.atZone(ZoneId.systemDefault());
        String id = zonedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        DailyLoadedStatistics stats = findOrCreate(id);
        stats.setLoadsCount(stats.getLoadsCount() + 1);
        repository.save(stats);
    }

    @EventHandler
    public void on(DataLoadFinishedEvent event, @Timestamp Instant time) {
        ZonedDateTime zonedDateTime = time.atZone(ZoneId.systemDefault());
        String id = zonedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        DailyLoadedStatistics stats = findOrCreate(id);
        stats.setRecordsCount(stats.getRecordsCount() + (event.getRecordsLoaded() == null? 0 : event.getRecordsLoaded()));
        repository.save(stats);
    }

    private DailyLoadedStatistics findOrCreate(String id) {
        return repository.findById(id)
                .orElse(DailyLoadedStatistics.builder()
                        .id(id)
                        .loadsCount(0L)
                        .recordsCount(0L)
                        .build());
    }


}

