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
@Table(name = "proc_actividades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procActividades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ACTIVIDAD", length = 10)
    private java.math.BigDecimal idActividad;

    @Column(name = "ID_PROC", length = 10)
    private java.math.BigDecimal idProc;

    @Column(name = "DESC_ACTIVIDAD", length = 50)
    private String descActividad;

    @Column(name = "ORDEN_EJEC", length = 2)
    private java.math.BigDecimal ordenEjec;

    @Column(name = "MODO_EJEC", length = 1)
    private String modoEjec;

    @Column(name = "ID_ACTIVIDAD_PADRE", length = 10)
    private java.math.BigDecimal idActividadPadre;

    @Column(name = "ESTADO", length = 10)
    private String estado;

    @Column(name = "CAUSA_FALLO", length = 200)
    private String causaFallo;

    @Column(name = "USU_EJECUTA", length = 50)
    private String usuEjecuta;

    @Column(name = "FEC_INI")
    private java.time.LocalDateTime fecIni;

    @Column(name = "FEC_FIN")
    private java.time.LocalDateTime fecFin;

}
