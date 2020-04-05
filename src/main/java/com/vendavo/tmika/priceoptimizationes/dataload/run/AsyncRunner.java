package com.vendavo.tmika.priceoptimizationes.dataload.run;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.event.AsyncRunningFinishedEvent;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadAggregate;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadResult;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Component
public class AsyncRunner {

    private static final Logger log = LoggerFactory.getLogger(AsyncRunner.class);

    @Autowired
    private EventGateway eventGateway;

    @Autowired
    EventSourcingRepository<DataLoadAggregate> repository;

    public void runDataLoad(String id) {
        DataLoadAggregate dataLoadById = getDataLoadById(id);
        log.info("Running data load job id:{}, file: {}", id, dataLoadById.getFile());
        CompletableFuture.supplyAsync(getDataLoadResultSupplier(id))
                .thenAccept(result -> eventGateway.publish(AsyncRunningFinishedEvent.builder()
                                .id(id)
                                .result(result)
                                .build())
                );
    }

    private Supplier<DataLoadResult> getDataLoadResultSupplier(String id) {
        return () -> {
            try {
                Thread.sleep(5000);
                log.info("Finished data load job id:{}", id);
                return DataLoadResult.SUCCESS;
            } catch (Exception e) {
                log.error("Failed data load job id:{}", id);
                return DataLoadResult.FAIL;
            }
        };
    }

    private DataLoadAggregate getDataLoadById(String id){
        return repository.load(id).getWrappedAggregate().getAggregateRoot();
    }

}
