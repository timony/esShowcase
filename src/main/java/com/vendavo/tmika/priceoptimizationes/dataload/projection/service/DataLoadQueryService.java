package com.vendavo.tmika.priceoptimizationes.dataload.projection.service;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.query.model.FindAllDataLoadsQuery;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.query.model.FindByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
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
        return queryGateway.query(new FindAllDataLoadsQuery(), ResponseTypes.multipleInstancesOf(DataLoad.class));
    }

    public CompletableFuture<DataLoad> getById(String id) {
        return queryGateway.query(new FindByIdQuery(id), DataLoad.class);
    }

}
