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
@Table(name = "ppen_pensionado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenPensionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TipoId", length = 10)
    private java.math.BigDecimal tipoid;

    @Column(name = "NumeroIdPensionado", length = 16)
    private java.math.BigDecimal numeroidpensionado;

    @Column(name = "TipoCliente", length = 1)
    private String tipocliente;

    @Column(name = "Nombres", length = 100)
    private String nombres;

    @Column(name = "Apellido1", length = 50)
    private String apellido1;

    @Column(name = "Apellido2", length = 50)
    private String apellido2;

    @Column(name = "Sexo", length = 1)
    private String sexo;

    @Column(name = "ActividadEconomica", length = 10)
    private java.math.BigDecimal actividadeconomica;

    @Column(name = "FechaFallecimiento")
    private java.time.LocalDateTime fechafallecimiento;

    @Column(name = "FechaFallecimientoPreRein")
    private java.time.LocalDateTime fechafallecimientoprerein;

    @Column(name = "DireccionEmail", length = 50)
    private String direccionemail;

    @Column(name = "COD_MUNICIPIO", length = 11)
    private java.math.BigDecimal codMunicipio;

    @Column(name = "Telefono", length = 20)
    private java.math.BigDecimal telefono;

    @Column(name = "Declarante", length = 2)
    private java.math.BigDecimal declarante;

    @Column(name = "IndicadorNoDeseado", length = 3)
    private String indicadornodeseado;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "PrimerNombre", length = 15)
    private String primernombre;

    @Column(name = "SegundoNombre", length = 15)
    private String segundonombre;

}
