package com.vendavo.tmika.priceoptimizationes.dataload.web;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.UploadDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.projection.model.DataLoad;
import com.vendavo.tmika.priceoptimizationes.dataload.query.model.FindAllDataLoadsQuery;
import com.vendavo.tmika.priceoptimizationes.dataload.query.model.FindByIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.IdentifierFactory;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DataLoadDomainService {

    @Autowired
    CommandGateway commandGateway;

    @Autowired
    QueryGateway queryGateway;

    public CompletableFuture<String> triggerNewDataLoad(String file) {
        return commandGateway.send(UploadDataLoadCommand.builder()
                .id(IdentifierFactory.getInstance().generateIdentifier())
                .file(file)
                .build());
    }

    public CompletableFuture<List<DataLoad>> getAll() {
        return queryGateway.query(new FindAllDataLoadsQuery(), ResponseTypes.multipleInstancesOf(DataLoad.class));
    }


    public CompletableFuture<DataLoad> getById(String id) {
        return queryGateway.query(new FindByIdQuery(id), DataLoad.class);
    }
}
