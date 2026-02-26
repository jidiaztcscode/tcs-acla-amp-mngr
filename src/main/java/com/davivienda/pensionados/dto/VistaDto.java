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
public class VistaDto {
    private BigDecimal idvista;
    private String nomvista;
    private String descvista;
    private String usuCreaApp;
    private LocalDateTime fecCreacion;
    private String usuModApp;
    private LocalDateTime fecModApp;
}
