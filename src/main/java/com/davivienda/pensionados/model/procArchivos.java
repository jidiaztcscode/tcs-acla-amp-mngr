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
@Table(name = "proc_archivos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procArchivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ARCHIVO", length = 10)
    private java.math.BigDecimal idArchivo;

    @Column(name = "DESC_ARCHIVO", length = 100)
    private String descArchivo;

    @Column(name = "NOM_EST_ARCHIVO", length = 50)
    private String nomEstArchivo;

    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Column(name = "ID_FUNCIONALIDAD", length = 28)
    private java.math.BigDecimal idFuncionalidad;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
