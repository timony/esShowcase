package com.vendavo.tmika.priceoptimizationes.dataload.saga;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.ChangeDataLoadStatusCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.command.FinishDataLoadCommand;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.AsyncRunningFinishedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadFinishedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.DataLoadUploadedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadStatus;
import com.vendavo.tmika.priceoptimizationes.dataload.run.AsyncRunner;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class DataLoadSaga {

    private static final Logger log = LoggerFactory.getLogger(DataLoadSaga.class);

    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private transient AsyncRunner runner;

    @SagaEventHandler(associationProperty = "id")
    @StartSaga
    public void on(DataLoadUploadedEvent event) {
        log.info("Data load saga {} starts with file {}", event.getId(), event.getFile());
        commandGateway.send(ChangeDataLoadStatusCommand.builder()
                .id(event.getId())
                .newStatus(DataLoadStatus.PENDING)
                .build());
        runner.runDataLoad(event.getId(), event.getFile());
        commandGateway.send(ChangeDataLoadStatusCommand.builder()
                .id(event.getId())
                .newStatus(DataLoadStatus.RUNNING)
                .build());
    }

    @SagaEventHandler(associationProperty = "id")
    public void on(AsyncRunningFinishedEvent event) {
        commandGateway.send(FinishDataLoadCommand.builder()
                .id(event.getId())
                .result(event.getResult())
                .build());
    }

    @SagaEventHandler(associationProperty = "id")
    @EndSaga
    public void on(DataLoadFinishedEvent event) {
        log.info("Data load saga {} ends with result {}", event.getId(), event.getResult());
    }

}
