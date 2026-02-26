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
@Table(name = "ppen_pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenPagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroPago", length = 10)
    private java.math.BigDecimal numeropago;

    @Column(name = "FechaPago")
    private java.time.LocalDateTime fechapago;

    @Column(name = "ValorPago", length = 16)
    private java.math.BigDecimal valorpago;

    @Column(name = "EstadoPago", length = 10)
    private java.math.BigDecimal estadopago;

    @Column(name = "OficinaAbono", length = 10)
    private java.math.BigDecimal oficinaabono;

    @Column(name = "NumeroAfiliacion", length = 16)
    private java.math.BigDecimal numeroafiliacion;

    @Column(name = "NumeroReintegro", length = 10)
    private java.math.BigDecimal numeroreintegro;

    @Column(name = "NumeroCuentaEmpresa", length = 16)
    private java.math.BigDecimal numerocuentaempresa;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "NumeroIdEmpresa", length = 16)
    private java.math.BigDecimal numeroidempresa;

    @Column(name = "CodigoRechazo", length = 10)
    private java.math.BigDecimal codigorechazo;

    @Column(name = "MotivoRechazo", length = 500)
    private String motivorechazo;

    @Column(name = "IdDetallePortal", length = 10)
    private java.math.BigDecimal iddetalleportal;

    @Column(name = "Trace_numberStratus", length = 20)
    private java.math.BigDecimal traceNumberstratus;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "Migrado", length = 2)
    private String migrado;

    @Column(name = "ValorReintegrado", length = 16)
    private java.math.BigDecimal valorreintegrado;

    @Column(name = "Id_Archivo_Numero_Cupon", length = 40)
    private String idArchivoNumeroCupon;

}
