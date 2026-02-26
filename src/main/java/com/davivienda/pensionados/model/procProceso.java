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
@Table(name = "proc_proceso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procProceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_PROC", length = 10)
    private java.math.BigDecimal idProc;

    @Column(name = "DESC_PROCESO", length = 50)
    private String descProceso;

    @Column(name = "NOM_PROCESO", length = 200)
    private String nomProceso;

    @Column(name = "TIPO_PROCESO", length = 20)
    private String tipoProceso;

    @Column(name = "ENTORNO_EJEC", length = 10)
    private String entornoEjec;

    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Column(name = "ID_FUNCIONALIDAD", length = 28)
    private java.math.BigDecimal idFuncionalidad;

    @Column(name = "CG_ARCHIVO", length = 1)
    private String cgArchivo;

    @Column(name = "GENERA_DETALLE_LOG", length = 1)
    private String generaDetalleLog;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
