package com.davivienda.pensionados.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class CuentasQuery {
    LocalDate fechaInicio;
    LocalDate fechaFin;
    Long numeroIdEmpresa;
    Long numeroIdPensionado;
    String tipoIdentificacion;
    Long numeroCuentaPensionado;
    Long cuentaEmpleador;
    Long numeroCuentaPagadora;
    Long idAfiliacion;
    @Builder.Default
    boolean ascending = true;
    String campoOrdenamiento;
    @Builder.Default
    int pagina = 1;
    @Builder.Default
    int registrosPorPagina = 20;   
}
