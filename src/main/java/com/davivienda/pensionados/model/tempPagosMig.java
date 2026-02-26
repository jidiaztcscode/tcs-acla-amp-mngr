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
@Table(name = "temp_pagos_mig")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempPagosMig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "NumeroCuentaPensionado", length = 12)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "MesadaIssPagada", length = 9)
    private String mesadaisspagada;

    @Column(name = "FechaPago")
    private java.time.LocalDateTime fechapago;

    @Column(name = "ValorPago", length = 11)
    private java.math.BigDecimal valorpago;

    @Column(name = "NumeroAfiliacion", length = 12)
    private java.math.BigDecimal numeroafiliacion;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue", length = 200)
    private String msjeErrorCargue;

}
