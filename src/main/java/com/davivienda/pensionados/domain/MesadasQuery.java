package com.davivienda.pensionados.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)

public class MesadasQuery {
    LocalDate fechaInicio;
    LocalDate fechaFin;
    Long numeroIdEmpresa;
    Long numeroAfiliacion;
    Long numeroCuentaPensionado;
    Long numeroIdPensionado;
    String tipoIdentificacion;
    Long numeroCuentaPagadora;
    @Builder.Default
    boolean ascending = true;
    String campoOrdenamiento;
    @Builder.Default
    int pagina = 1;
    @Builder.Default
    int registrosPorPagina = 20;
}
