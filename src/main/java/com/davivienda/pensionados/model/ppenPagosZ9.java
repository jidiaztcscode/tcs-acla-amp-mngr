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
@Table(name = "ppen_pagos_z9")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenPagosZ9 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IdPago", length = 10)
    private java.math.BigDecimal idpago;

    @Column(name = "FechaPago")
    private java.time.LocalDateTime fechapago;

    @Column(name = "ValorPago", length = 16)
    private java.math.BigDecimal valorpago;

    @Column(name = "NumeroAfiliacion", length = 16)
    private java.math.BigDecimal numeroafiliacion;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "MesadaIssPagada", length = 9)
    private String mesadaisspagada;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "Cuenta_Davivienda", length = 16)
    private java.math.BigDecimal cuentaDavivienda;

}
