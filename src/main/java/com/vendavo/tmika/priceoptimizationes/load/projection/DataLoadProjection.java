package com.vendavo.tmika.priceoptimizationes.load.projection;

import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadRequestedEvent;
import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadStatusChangedEvent;
import com.vendavo.tmika.priceoptimizationes.load.projection.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.load.projection.repository.DataLoadRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DataLoadProjection {

    @Autowired
    DataLoadRepository repository;

    @EventHandler
    public void handle(DataLoadRequestedEvent event, @Timestamp Instant time) {
        DataLoad dataLoad = findOrCreate(event.getId());
        dataLoad.setFile(event.getFile());
        dataLoad.setRequestTime(time);
        dataLoad.setStatus(event.getStatus());
        repository.save(dataLoad);
    }

    @EventHandler
    public void handle(DataLoadStatusChangedEvent event) {
        DataLoad dataLoad = findOrCreate(event.getId());
        dataLoad.setStatus(event.getNewStatus());
        repository.save(dataLoad);
    }

    private DataLoad findOrCreate(String id) {
        return repository.findById(id)
                .orElse(DataLoad.builder()
                        .id(id)
                        .build());
    }
}
