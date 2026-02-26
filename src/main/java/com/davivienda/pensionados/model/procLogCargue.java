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
@Table(name = "proc_log_cargue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procLogCargue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUM_FILA", length = 10)
    private java.math.BigDecimal numFila;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "ID_ARCHIVO", length = 10)
    private java.math.BigDecimal idArchivo;

    @Column(name = "DATOS")
    private String datos;

    @Column(name = "NOM_ARCHIVO_CG", length = 100)
    private String nomArchivoCg;

    @Column(name = "COD_FALLO", length = 500)
    private String codFallo;

    @Column(name = "ID_LOG_PROC", length = 10)
    private java.math.BigDecimal idLogProc;

    @Column(name = "CAMP_LONGITUD")
    private String campLongitud;

    @Column(name = "CAMP_OBLIGATORIO")
    private String campObligatorio;

    @Column(name = "CAMP_TIPO_DATO")
    private String campTipoDato;

    @Column(name = "ESTADOBD", length = 20)
    private String estadobd;

    @Column(name = "MSJBD")
    private String msjbd;

    @Column(name = "CAMP_NUM_AFILIA")
    private String campNumAfilia;

}
