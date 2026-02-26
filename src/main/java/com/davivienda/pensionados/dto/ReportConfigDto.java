package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportConfigDto {
    private BigDecimal idconsulta;
    private BigDecimal idFuncionalidad;
    private BigDecimal idvista;
    private String nomconsulta;
    private String descconsulta;
    private String encab;
    private String conteo;
    private String regcontrol;
    private String usuCreaApp;
    private LocalDateTime fecCreacion;
    private String usuModApp;
    private LocalDateTime fecModApp;
    private List<ReportColumnDto> columns;
    private List<ReportFilterDto> filters;
}
