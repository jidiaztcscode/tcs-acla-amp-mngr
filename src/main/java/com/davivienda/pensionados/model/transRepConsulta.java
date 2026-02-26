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
@Table(name = "trans_rep_consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class transRepConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDCONSULTA", length = 10)
    private java.math.BigDecimal idconsulta;

    @Column(name = "ID_FUNCIONALIDAD", length = 28)
    private java.math.BigDecimal idFuncionalidad;

    @Column(name = "IDVISTA", length = 10)
    private java.math.BigDecimal idvista;

    @Column(name = "NOMCONSULTA", length = 200)
    private String nomconsulta;

    @Column(name = "DESCCONSULTA")
    private String descconsulta;

    @Column(name = "ENCAB", length = 1)
    private String encab;

    @Column(name = "CONTEO", length = 1)
    private String conteo;

    @Column(name = "REGCONTROL", length = 1)
    private String regcontrol;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
