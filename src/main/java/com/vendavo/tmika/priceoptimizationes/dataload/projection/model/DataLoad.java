package com.vendavo.tmika.priceoptimizationes.dataload.projection.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadResult;
import com.vendavo.tmika.priceoptimizationes.dataload.domain.model.DataLoadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "dataload")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "file"})
public class DataLoad {

    @Id
    private String id;

    private String file;

    @Enumerated(EnumType.STRING)
    private DataLoadStatus status;

    private Instant requestTime;

    private Instant startTime;

    private Instant endTime;

    @Enumerated(EnumType.STRING)
    private DataLoadResult result;
}
