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
@Table(name = "proc_parametro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procParametro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_PARAM", length = 10)
    private java.math.BigDecimal idParam;

    @Column(name = "DESC_PARAMETRO", length = 100)
    private String descParametro;

    @Column(name = "NOM_PARAMTERO", length = 50)
    private String nomParamtero;

    @Column(name = "VAL_PARAMETRO", length = 500)
    private String valParametro;

    @Column(name = "VAL_ACTUAL_PARAM", length = 50)
    private String valActualParam;

    @Column(name = "TIPO_DATO_PARAM", length = 10)
    private String tipoDatoParam;

    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Column(name = "ID_APP", length = 10)
    private java.math.BigDecimal idApp;

    @Column(name = "ID_FUNCIONALIDAD", length = 28)
    private java.math.BigDecimal idFuncionalidad;

    @Column(name = "EXISTE_ARCHIVO")
    private Boolean existeArchivo;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
