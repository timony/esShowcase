package com.vendavo.tmika.priceoptimizationes.load.saga;

import com.vendavo.tmika.priceoptimizationes.load.domain.event.DataLoadRequestedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class DataLoadSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @SagaEventHandler(associationProperty = "id")
    @StartSaga
    public void dataLoadRequested(DataLoadRequestedEvent event) {

    }
}
