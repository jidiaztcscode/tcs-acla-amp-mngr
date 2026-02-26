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
@Table(name = "proc_mapa_archivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procMapaArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_MAPA", length = 10)
    private java.math.BigDecimal idMapa;

    @Column(name = "POS_INI", length = 5)
    private java.math.BigDecimal posIni;

    @Column(name = "POS_FIN", length = 5)
    private java.math.BigDecimal posFin;

    @Column(name = "NOM_COLUMNA", length = 50)
    private String nomColumna;

    @Column(name = "TIPO_DATO", length = 10)
    private String tipoDato;

    @Column(name = "LONGITUD", length = 3)
    private java.math.BigDecimal longitud;

    @Column(name = "ID_ARCHIVO", length = 10)
    private java.math.BigDecimal idArchivo;

    @Column(name = "CARACTER_RELLENO", length = 1)
    private String caracterRelleno;

    @Column(name = "JUSTIFICACION", length = 1)
    private String justificacion;

    @Column(name = "VAL_DEFECETO", length = 50)
    private String valDefeceto;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "CAMPO_OBLIGATORIO", length = 1)
    private String campoObligatorio;

    @Column(name = "ID_FORMATO_FECHA")
    private Integer idFormatoFecha;

}
