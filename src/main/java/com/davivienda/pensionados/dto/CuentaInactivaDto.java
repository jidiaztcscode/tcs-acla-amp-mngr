package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CuentaInactivaDto {
    Long idAfiliacion;
    String nombrePensionado;
    Long numeroIdPensionado;
    String desTipoIdentificacion;
    Long numeroCuentaPensionado;
    LocalDate fechaAperturaCuenta;
    LocalDate fechaUltimoRetiro;
    LocalDate fechaUltimoAbono;
    String desObjetivoCuenta;
    String desMedioTransacional;
    Long cuentaEmpleador;
    String nombreEmpresa;
    Long numeroIdEmpresa;
    BigDecimal valorTotalMesadas;
    LocalDate fechaInactividad;
}
