package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReintegroRechazadoDto {
    Long numeroAfiliacionPago;
    Long oficinaApertura;
    Long numeroCuentaPensionado;
    Long numeroIdPensionado;
    String tipoIdentificacion;
    String nombrePensionado;
    LocalDate fechaFallecimiento;
    String estadoCuenta;
    String mesadaDespuesFallecimiento;
    BigDecimal valorMesadaDespuesFallecer;
    Long cuentaDestinoReintegro;
    String motivoRechazo;
    LocalDate fechaSolReintegro;
    Long numeroIdEmpresa;
    String nombreEmpresa;
    
}
