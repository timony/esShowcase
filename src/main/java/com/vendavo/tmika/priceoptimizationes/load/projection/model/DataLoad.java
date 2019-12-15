package com.vendavo.tmika.priceoptimizationes.load.projection.model;

import com.vendavo.tmika.priceoptimizationes.projection.model.AuditModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataload")
@Data
public class DataLoad extends AuditModel {

    @Id
    @GeneratedValue
    private Long id;
}
