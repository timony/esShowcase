package com.vendavo.tmika.priceoptimizationes.dataload.domain.web;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.UploadDataLoadCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DataLoadDomainService {

    @Autowired
    CommandGateway commandGateway;

    public CompletableFuture<String> triggerNewDataLoad(String file) {
        return commandGateway.send(UploadDataLoadCommand.builder()
                .id(IdentifierFactory.getInstance().generateIdentifier())
                .file(file)
                .build());
    }


}
