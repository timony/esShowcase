package com.vendavo.tmika.priceoptimizationes.dataload.projection.base.repository;

import com.vendavo.tmika.priceoptimizationes.dataload.projection.base.model.DataLoad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLoadRepository extends CrudRepository<DataLoad, String> {
}
