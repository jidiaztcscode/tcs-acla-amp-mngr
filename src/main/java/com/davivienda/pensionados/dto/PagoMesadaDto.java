package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PagoMesadaDto {
    Long identificadorDetalle;
    Long numeroAfiliacionPago;
    String oficinaApertura;
    String numeroCuentaPensionado;
    LocalDate fechaAbonoMesada;
    Long numeroIdPensionado;
    String tipoId;
    String tipoIdentificacion;
    String tipoIdColpensiones;
    String nombrePensionado;
    String numeroCuentaPagadora;
    BigDecimal valorMesada;
    String estadoPago;
    Long numeroIdEmpresa;
    String nombreEmpresa;
    
}
