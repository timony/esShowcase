package com.vendavo.tmika.priceoptimizationes.load.projection;

import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadRequestedEvent;
import com.vendavo.tmika.priceoptimizationes.load.projection.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.load.projection.repository.DataLoadRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoadProjection {

    @Autowired
    DataLoadRepository repository;

    @EventHandler
    public void handle(DataLoadRequestedEvent event) {
        DataLoad dataLoad = repository.findById(event.getId())
                .orElse(DataLoad.builder()
                        .id(event.getId())
                        .file(event.getFile())
                        .build());
        repository.save(dataLoad);
    }
}
