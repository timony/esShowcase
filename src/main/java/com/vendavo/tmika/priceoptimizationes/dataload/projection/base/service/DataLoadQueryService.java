package com.vendavo.tmika.priceoptimizationes.dataload.projection.base.service;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.query.model.FindByIdQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DataLoadQueryService {

    @Autowired
    QueryGateway queryGateway;

    public CompletableFuture<List<DataLoad>> getAll() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public CompletableFuture<DataLoad> getById(String id) {
        return queryGateway.query(new FindByIdQuery(id), DataLoad.class);
    }

}
