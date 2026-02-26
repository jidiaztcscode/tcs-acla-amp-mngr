package com.davivienda.pensionados.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CertificadoMesadaDto {
    String tipoDocumento;
    String numeroDocumento;
    String primerApellido;
    String segundoApellido;
    String primerNombre;
    String segundoNombre;
    String periodoNomina;
    String referencia;
    String banco;
    String sucursal;
    String cuenta;
    String tipoCuenta;
    BigDecimal valorNeto;
    String estadoPago;
    LocalDate fechaPago;
    String descripcionCausalNoPago;
    String causalNoPago;    
}
