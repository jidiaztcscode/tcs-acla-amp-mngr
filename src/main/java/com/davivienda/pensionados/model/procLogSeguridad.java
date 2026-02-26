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
@Table(name = "proc_log_seguridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procLogSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_LOG_SEG", length = 10)
    private java.math.BigDecimal idLogSeg;

    @Column(name = "USUARIO", length = 20)
    private String usuario;

    @Column(name = "FEC_EJEC_INI")
    private java.time.LocalDateTime fecEjecIni;

    @Column(name = "TIPO_EVENTO", length = 20)
    private String tipoEvento;

    @Column(name = "ORIGEN_EVENTO")
    private String origenEvento;

    @Column(name = "DATO_ANTERIOR")
    private String datoAnterior;

    @Column(name = "DATO_NUEVO")
    private String datoNuevo;

    @Column(name = "NOMBRE_CAMPO")
    private String nombreCampo;

    @Column(name = "RESULT_PROCESO")
    private String resultProceso;

    @Column(name = "APLICACION", length = 50)
    private String aplicacion;

    @Column(name = "DIR_IP", length = 20)
    private String dirIp;

}
