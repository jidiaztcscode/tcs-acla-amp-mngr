package com.davivienda.pensionados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ppen_metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_metadata", length = 10)
    private java.math.BigDecimal idMetadata;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "CodEstandar", length = 20)
    private String codestandar;

}
