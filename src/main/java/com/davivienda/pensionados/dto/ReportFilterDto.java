package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    
    // Date range fields for filtering
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
