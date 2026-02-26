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
@Table(name = "ppen_empresa_pagadora")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenEmpresaPagadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroIdEmpresa", length = 16)
    private java.math.BigDecimal numeroidempresa;

    @Column(name = "TipoId", length = 10)
    private java.math.BigDecimal tipoid;

    @Column(name = "NombreEmpresa", length = 100)
    private String nombreempresa;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
