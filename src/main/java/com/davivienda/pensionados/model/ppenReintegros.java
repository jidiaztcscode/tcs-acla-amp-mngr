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
@Table(name = "ppen_reintegros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenReintegros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroReintegro", length = 10)
    private java.math.BigDecimal numeroreintegro;

    @Column(name = "TipoReintegro", length = 1)
    private String tiporeintegro;

    @Column(name = "FechaSolReintegro")
    private java.time.LocalDateTime fechasolreintegro;

    @Column(name = "ValorTotalSolicitado", length = 20)
    private java.math.BigDecimal valortotalsolicitado;

    @Column(name = "EstadoReintegro", length = 10)
    private java.math.BigDecimal estadoreintegro;

    @Column(name = "CantidadTotalSolicitada", length = 10)
    private java.math.BigDecimal cantidadtotalsolicitada;

    @Column(name = "MensajeRechazo", length = 100)
    private String mensajerechazo;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "NombreArchivo", length = 50)
    private String nombrearchivo;

    @Column(name = "NombreArchivoStratus", length = 50)
    private String nombrearchivostratus;

    @Column(name = "UsuarioAprobacion", length = 100)
    private String usuarioaprobacion;

    @Column(name = "FechaAprobacion")
    private java.time.LocalDateTime fechaaprobacion;

    @Column(name = "NumeroCuentaEmpresa", length = 16)
    private java.math.BigDecimal numerocuentaempresa;

    @Column(name = "FechaRtaReintegro")
    private java.time.LocalDateTime fechartareintegro;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "NumeroIdEmpresa", length = 16)
    private java.math.BigDecimal numeroidempresa;

    @Column(name = "EnviadoPortafolio", length = 2)
    private String enviadoportafolio;

    @Column(name = "FechaEnvioPortafolio")
    private java.time.LocalDateTime fechaenvioportafolio;

    @Column(name = "EnviadoFondo", length = 2)
    private String enviadofondo;

    @Column(name = "FechaEnvioFondo")
    private java.time.LocalDateTime fechaenviofondo;

}
