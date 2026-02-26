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
@Table(name = "temp_mig_cuentas_pagadora")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempMigCuentasPagadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "TipoCuenta", length = 4)
    private java.math.BigDecimal tipocuenta;

    @Column(name = "NumeroCuentaEmpresa", length = 16)
    private java.math.BigDecimal numerocuentaempresa;

    @Column(name = "NumeroIdEmpresa", length = 16)
    private java.math.BigDecimal numeroidempresa;

    @Column(name = "NombreEmpresa", length = 100)
    private String nombreempresa;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue", length = 200)
    private String msjeErrorCargue;

}
