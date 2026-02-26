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
@Table(name = "temp_cto_mig")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempCtoMig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "CUENTA", length = 12)
    private java.math.BigDecimal cuenta;

    @Column(name = "TIPO_CUENTA", length = 2)
    private String tipoCuenta;

    @Column(name = "EMPRESA", length = 15)
    private String empresa;

    @Column(name = "REF_1", length = 10)
    private java.math.BigDecimal ref1;

    @Column(name = "REF_2", length = 6)
    private java.math.BigDecimal ref2;

    @Column(name = "VALOR", length = 10)
    private java.math.BigDecimal valor;

    @Column(name = "TIPO_MOVIMIENTO", length = 2)
    private String tipoMovimiento;

    @Column(name = "MOTIVO", length = 3)
    private java.math.BigDecimal motivo;

    @Column(name = "TIPO_COBRO", length = 1)
    private java.math.BigDecimal tipoCobro;

    @Column(name = "FECHA")
    private java.time.LocalDateTime fecha;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue", length = 200)
    private String msjeErrorCargue;

}
