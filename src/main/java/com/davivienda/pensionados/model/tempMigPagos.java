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
@Table(name = "temp_mig_pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempMigPagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "Cuenta_pensionado", length = 12)
    private java.math.BigDecimal cuentaPensionado;

    @Column(name = "Fecha_mesada")
    private java.time.LocalDateTime fechaMesada;

    @Column(name = "Fecha_pago")
    private java.time.LocalDateTime fechaPago;

    @Column(name = "Valor_pago", length = 11)
    private java.math.BigDecimal valorPago;

    @Column(name = "Referencia", length = 16)
    private java.math.BigDecimal referencia;

    @Column(name = "Relleno", length = 2)
    private String relleno;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue", length = 200)
    private String msjeErrorCargue;

}
