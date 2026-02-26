package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AperturaCuentaDto {
    Long idAfiliacion;
    Long numeroIdPensionado;
    String desTipoIdentificacion;
    String nombrePensionado;
    String oficinaApertura;
    Long numeroCuentaPensionado;
    String estadoCuenta;
    LocalDate fechaAperturaCuenta;
    String desMedioTransacional;
    String desObjetivoCuenta;
    Long cuentaEmpleador;
    Long numeroIdEmpresa;
    String nombreEmpresa;
}
