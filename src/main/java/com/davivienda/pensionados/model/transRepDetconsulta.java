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
@Table(name = "trans_rep_detconsulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class transRepDetconsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_DETCONSULTA", length = 10)
    private java.math.BigDecimal idDetconsulta;

    @Column(name = "IDCONSULTA", length = 10)
    private java.math.BigDecimal idconsulta;

    @Column(name = "ID_DETVISTA", length = 10)
    private java.math.BigDecimal idDetvista;

    @Column(name = "NOMCAMPO", length = 100)
    private String nomcampo;

    @Column(name = "SUMCOLUMNA", length = 1)
    private String sumcolumna;

    @Column(name = "TIPORELLENO", length = 200)
    private String tiporelleno;

    @Column(name = "TIPOJUST", length = 1)
    private String tipojust;

    @Column(name = "LONGITUD")
    private Integer longitud;

}
