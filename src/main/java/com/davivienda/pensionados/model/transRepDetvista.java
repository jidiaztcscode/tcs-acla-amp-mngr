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
@Table(name = "trans_rep_detvista")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class transRepDetvista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_DETVISTA", length = 10)
    private java.math.BigDecimal idDetvista;

    @Column(name = "IDVISTA", length = 10)
    private java.math.BigDecimal idvista;

    @Column(name = "NOMCOLUNNA", length = 200)
    private String nomcolunna;

    @Column(name = "TIPO_DATO", length = 50)
    private String tipoDato;

    @Column(name = "LONGITUD")
    private Integer longitud;

    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Column(name = "PERTENECEVISTA", length = 1)
    private String pertenecevista;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
