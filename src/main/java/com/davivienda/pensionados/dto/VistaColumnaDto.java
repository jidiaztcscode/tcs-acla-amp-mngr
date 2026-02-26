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
public class VistaColumnaDto {
    private BigDecimal idDetvista;
    private BigDecimal idvista;
    private String nomcolunna;
    private String tipoDato;
    private Integer longitud;
    private String estado;
    private String pertenecevista;
    private String usuCreaApp;
    private LocalDateTime fecCreacion;
    private String usuModApp;
    private LocalDateTime fecModApp;
}
