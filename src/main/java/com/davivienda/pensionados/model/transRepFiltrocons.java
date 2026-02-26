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
@Table(name = "trans_rep_filtrocons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class transRepFiltrocons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_FILTRO", length = 10)
    private java.math.BigDecimal idFiltro;

    @Column(name = "IDCONSULTA", length = 10)
    private java.math.BigDecimal idconsulta;

    @Column(name = "ID_DETVISTA", length = 10)
    private java.math.BigDecimal idDetvista;

    @Column(name = "ORDEN")
    private Integer orden;

    @Column(name = "INCLUYENTE", length = 1)
    private String incluyente;

    @Column(name = "TIPO_FILTRO", length = 10)
    private java.math.BigDecimal tipoFiltro;

    @Column(name = "VAL_FILTRO")
    private String valFiltro;

    @Column(name = "ID_DETCONSULTA2", length = 10)
    private java.math.BigDecimal idDetconsulta2;

}
