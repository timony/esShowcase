package com.vendavo.tmika.priceoptimizationes.dataload.projection.base;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.repository.DataLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataLoadProjection {

    @Autowired
    DataLoadRepository repository;

}
