package com.davivienda.pensionados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "temp_pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempPagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "IdentificadorDetalle", length = 10)
    private java.math.BigDecimal identificadordetalle;

    @Column(name = "Trace_number", length = 20)
    private java.math.BigDecimal traceNumber;

    @Column(name = "Fecha_pago")
    private java.time.LocalDateTime fechaPago;

    @Column(name = "Nit_empresa_pagadora", length = 20)
    private java.math.BigDecimal nitEmpresaPagadora;

    @Column(name = "Nombre_empresa_pagadora", length = 100)
    private String nombreEmpresaPagadora;

    @Column(name = "Tipo_cuenta_pagadora", length = 4)
    private java.math.BigDecimal tipoCuentaPagadora;

    @Column(name = "Cuenta_pagadora", length = 16)
    private java.math.BigDecimal cuentaPagadora;

    @Column(name = "Cuenta_pensionado", length = 16)
    private java.math.BigDecimal cuentaPensionado;

    @Column(name = "Valor_pago", length = 18)
    private java.math.BigDecimal valorPago;

    @Column(name = "Referencia", length = 16)
    private java.math.BigDecimal referencia;

    @Column(name = "Oficina_abono", length = 4)
    private java.math.BigDecimal oficinaAbono;

    @Column(name = "Estado_pago", length = 10)
    private String estadoPago;

    @Column(name = "Codigo_rechazo", length = 10)
    private java.math.BigDecimal codigoRechazo;

    @Column(name = "Mensaje_rechazo", length = 500)
    private String mensajeRechazo;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue", length = 200)
    private String msjeErrorCargue;

}
