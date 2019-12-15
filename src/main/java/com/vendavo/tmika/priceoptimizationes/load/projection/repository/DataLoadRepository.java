package com.vendavo.tmika.priceoptimizationes.load.projection.repository;

import com.vendavo.tmika.priceoptimizationes.load.projection.model.DataLoad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLoadRepository extends CrudRepository<DataLoad, String> {
}
