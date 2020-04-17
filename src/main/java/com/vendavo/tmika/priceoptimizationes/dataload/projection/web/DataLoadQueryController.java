package com.vendavo.tmika.priceoptimizationes.dataload.projection.web;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.service.DataLoadQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/v1/dataload", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataLoadQueryController {

    @Autowired
    DataLoadQueryService service;

    @GetMapping
    public CompletableFuture<List<DataLoad>> getAllDataLoads() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public CompletableFuture<DataLoad> getDataLoadById(@PathVariable String id) {
        return service.getById(id);
    }
}
