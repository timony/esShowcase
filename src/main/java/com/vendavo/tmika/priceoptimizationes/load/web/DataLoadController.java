package com.vendavo.tmika.priceoptimizationes.load.web;

import com.vendavo.tmika.priceoptimizationes.load.projection.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.load.web.request.TriggerDataLoadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/v1/dataload", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataLoadController {

    @Autowired
    private DataLoadDomainService service;

    @PostMapping
    public CompletableFuture<String> triggerDataLoad(@RequestBody TriggerDataLoadRequest request) {
        return service.triggerNewDataLoad(request.getFile());
    }

    @GetMapping
    public CompletableFuture<List<DataLoad>> getAllDataLoads() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public CompletableFuture<DataLoad> getDataLoadById(@PathVariable String id) {
        return service.getById(id);
    }
}
