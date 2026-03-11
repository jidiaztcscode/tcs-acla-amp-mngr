package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReintegroFallecimientoDto {
     Long numeroAfiliacionPago;
    String nombrePensionado;
    Long numeroIdPensionado;
    String tipoIdentificacion;
    LocalDate fechaAperturaCuenta;
    Long numeroCuentaPensionado;
    Long oficinaApertura;
    LocalDate fechaFallecimiento;
    String mesadaReintegrada;
    BigDecimal valorReintegrado;
    Long cuentaDestinoReintegro;
    LocalDate fechaReintegro;
    Long numeroIdEmpresa;
    String nombreEmpresa;
    Integer totalMesadasDespuesFallecer;
    BigDecimal valorMesadasDespuesFallecer;
    Integer cantidadReintegrosExitosos;
    BigDecimal valorReintegrosExitosos;

}
