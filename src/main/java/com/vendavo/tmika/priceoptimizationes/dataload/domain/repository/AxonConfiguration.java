package com.vendavo.tmika.priceoptimizationes.dataload.domain.repository;

import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfiguration {

    @Bean
    EventSourcingRepository<DataLoadAggregate> dataLoadAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<DataLoadAggregate> repository = EventSourcingRepository.builder(DataLoadAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
