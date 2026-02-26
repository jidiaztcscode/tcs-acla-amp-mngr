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
@Table(name = "proc_cargue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procCargue {

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

    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Column(name = "FEC_CARGUE")
    private java.time.LocalDateTime fecCargue;

    @Column(name = "CAMP_LONGITUD")
    private String campLongitud;

    @Column(name = "CAMP_OBLIGATORIO")
    private String campObligatorio;

    @Column(name = "CAMP_TIPO_DATO")
    private String campTipoDato;

    @Column(name = "Usuario", length = 50)
    private String usuario;

    @Column(name = "CAMP_NUM_AFILIA")
    private String campNumAfilia;

}
