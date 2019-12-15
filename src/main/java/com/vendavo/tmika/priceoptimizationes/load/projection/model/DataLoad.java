package com.vendavo.tmika.priceoptimizationes.load.projection.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vendavo.tmika.priceoptimizationes.projection.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataload")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "file"})
public class DataLoad extends AuditModel {

    @Id
    private String id;

    private String file;
}
