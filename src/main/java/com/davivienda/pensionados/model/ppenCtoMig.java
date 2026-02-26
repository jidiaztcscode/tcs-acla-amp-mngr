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
@Table(name = "ppen_cto_mig")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenCtoMig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUENTA", length = 12)
    private java.math.BigDecimal cuenta;

    @Column(name = "CUENTA_DAVIVIENDA", length = 16)
    private java.math.BigDecimal cuentaDavivienda;

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

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

    @Column(name = "PROCESADO", length = 2)
    private String procesado;

    @Column(name = "ID_TEM_CTO_MIG", length = 10)
    private java.math.BigDecimal idTemCtoMig;

}
