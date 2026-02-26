package com.davivienda.pensionados.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MesadaResumenDto {
    String pensionadoId;
    String pensionadoNombre;
    String tipoDocumento;
    String numeroDocumento;
    BigDecimal valorDevengado;
    BigDecimal valorDeducido;
    BigDecimal valorNeto;
    String periodo;
}
