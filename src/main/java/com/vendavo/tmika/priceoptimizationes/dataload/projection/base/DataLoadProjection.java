package com.vendavo.tmika.priceoptimizationes.dataload.projection.base;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadStatusChangedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadUploadedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.repository.DataLoadRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Component
@Transactional
public class DataLoadProjection {

    @Autowired
    DataLoadRepository repository;

    @EventHandler
    public void on(DataLoadUploadedEvent event, @Timestamp Instant time) {
        DataLoad dataLoad = findOrCreate(event.getId());
        dataLoad.setFile(event.getFile());
        dataLoad.setRequestTime(time);
        dataLoad.setStatus(event.getNewStatus());
        repository.save(dataLoad);
    }

    @EventHandler
    public void on(DataLoadStatusChangedEvent event) {
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
