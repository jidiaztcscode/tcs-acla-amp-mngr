package com.davivienda.pensionados.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportColumnDto {
    private BigDecimal idDetconsulta;
    private BigDecimal idDetvista;
    private String nomcampo;
    private String sumcolumna;
    private String tiporelleno;
    private String tipojust;
    private Integer longitud;
}
