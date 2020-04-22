package com.vendavo.tmika.priceoptimizationes.dataload.projection.base.query;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.query.model.FindByIdQuery;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.repository.DataLoadRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataLoadQueryHandler {

    @Autowired
    DataLoadRepository repository;

    @QueryHandler
    public Optional<DataLoad> getDataLoad(FindByIdQuery query) {
        return repository.findById(query.getId());
    }
}
