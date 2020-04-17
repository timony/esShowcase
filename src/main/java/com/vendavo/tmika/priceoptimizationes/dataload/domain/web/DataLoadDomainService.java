package com.vendavo.tmika.priceoptimizationes.dataload.domain.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DataLoadDomainService {

    @Autowired
    CommandGateway commandGateway;

    public CompletableFuture<String> triggerNewDataLoad(String file) {
        throw new UnsupportedOperationException();
    }


}
