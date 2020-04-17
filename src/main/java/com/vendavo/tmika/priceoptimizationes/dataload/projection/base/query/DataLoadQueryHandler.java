package com.vendavo.tmika.priceoptimizationes.dataload.projection.base.query;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.repository.DataLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoadQueryHandler {

    @Autowired
    DataLoadRepository repository;

}
