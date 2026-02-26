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
@Table(name = "temp_colpago")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempColpago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "ID_LOG_PROCESO", length = 16)
    private java.math.BigDecimal idLogProceso;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "TRAMA_COLPAGO", length = 400)
    private String tramaColpago;

    @Column(name = "NUMERODOCUMENTO", length = 16)
    private java.math.BigDecimal numerodocumento;

    @Column(name = "PERIODONOMINA", length = 6)
    private java.math.BigDecimal periodonomina;

    @Column(name = "CUENTA", length = 20)
    private java.math.BigDecimal cuenta;

    @Column(name = "VALORNETO", length = 16)
    private java.math.BigDecimal valorneto;

    @Column(name = "REFERENCIA", length = 50)
    private String referencia;

    @Column(name = "SUCURSAL", length = 4)
    private java.math.BigDecimal sucursal;

    @Column(name = "PRIMERAPELLIDO", length = 15)
    private String primerapellido;

    @Column(name = "SEGUNDOAPELLIDO", length = 15)
    private String segundoapellido;

    @Column(name = "PRIMERNOMBRE", length = 15)
    private String primernombre;

    @Column(name = "SEGUNDONOMBRE", length = 15)
    private String segundonombre;

    @Column(name = "FEC_REPROCESO", length = 8)
    private String fecReproceso;

    @Column(name = "FEC_MATCH")
    private java.time.LocalDateTime fecMatch;

    @Column(name = "NUMERO_PAGO", length = 10)
    private java.math.BigDecimal numeroPago;

}
