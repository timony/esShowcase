package com.vendavo.tmika.priceoptimizationes.dataload.query;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.repository.DataLoadRepository;
import com.vendavo.tmika.priceoptimizationes.dataload.query.model.FindAllDataLoadsQuery;
import com.vendavo.tmika.priceoptimizationes.dataload.query.model.FindByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DataLoadQueryHandler {

    @Autowired
    DataLoadRepository repository;

    @QueryHandler
    public List<DataLoad> getAllDataLoads(FindAllDataLoadsQuery query) {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public Optional<DataLoad> getDataLoad(FindByIdQuery query) {
        return repository.findById(query.getId());
    }
}
