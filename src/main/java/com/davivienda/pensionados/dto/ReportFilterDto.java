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
public class ReportFilterDto {
    private BigDecimal idFiltro;
    private BigDecimal idDetvista;
    private Integer orden;
    private String incluyente;
    private BigDecimal tipoFiltro;
    private String valFiltro;
    private BigDecimal idDetconsulta2;
}
