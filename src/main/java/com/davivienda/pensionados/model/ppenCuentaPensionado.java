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
@Table(name = "ppen_cuenta_pensionado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenCuentaPensionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroIdPensionado", length = 16)
    private java.math.BigDecimal numeroidpensionado;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "TipoCuentaPesionado", length = 10)
    private java.math.BigDecimal tipocuentapesionado;

    @Column(name = "ClaseCuenta", length = 10)
    private java.math.BigDecimal clasecuenta;

    @Column(name = "Subproducto", length = 4)
    private java.math.BigDecimal subproducto;

    @Column(name = "EstadoCuenta", length = 1)
    private String estadocuenta;

    @Column(name = "TipoMoneda", length = 10)
    private java.math.BigDecimal tipomoneda;

    @Column(name = "ObjetivoCuenta", length = 10)
    private java.math.BigDecimal objetivocuenta;

    @Column(name = "CodigoCompania", length = 2)
    private java.math.BigDecimal codigocompania;

    @Column(name = "FechaAperturaCuenta")
    private java.time.LocalDateTime fechaaperturacuenta;

    @Column(name = "MedioTransacional", length = 10)
    private java.math.BigDecimal mediotransacional;

    @Column(name = "FechaCambioEstado")
    private java.time.LocalDateTime fechacambioestado;

    @Column(name = "FechaUltimoRetiro")
    private java.time.LocalDateTime fechaultimoretiro;

    @Column(name = "NroCuentaPagadora", length = 16)
    private java.math.BigDecimal nrocuentapagadora;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "TipoCuentaPensionado", length = 2)
    private String tipocuentapensionado;

    @Column(name = "Migrado", length = 2)
    private String migrado;

    @Column(name = "TipoAperturaCuenta", length = 2)
    private String tipoaperturacuenta;

}
