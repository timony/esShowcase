package com.vendavo.tmika.priceoptimizationes.dataload.projection.repository;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.model.DataLoad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLoadRepository extends CrudRepository<DataLoad, String> {
}
