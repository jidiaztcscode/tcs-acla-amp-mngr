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
@Table(name = "ppen_portafolio_rta_fondo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenPortafolioRtaFondo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "NUM_FILA", length = 10)
    private java.math.BigDecimal numFila;

    @Column(name = "NUMERO_REINTEGRO", length = 10)
    private java.math.BigDecimal numeroReintegro;

    @Column(name = "DATOS")
    private String datos;

    @Column(name = "MSJE_REINTEGRO")
    private String msjeReintegro;

    @Column(name = "TIPO_ERROR", length = 20)
    private String tipoError;

    @Column(name = "RTA_BANCO", length = 2)
    private java.math.BigDecimal rtaBanco;

}
