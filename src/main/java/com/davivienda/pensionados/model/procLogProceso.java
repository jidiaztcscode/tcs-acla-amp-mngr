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
@Table(name = "proc_log_proceso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procLogProceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_LOG_PROC", length = 10)
    private java.math.BigDecimal idLogProc;

    @Column(name = "ID_PROC", length = 10)
    private java.math.BigDecimal idProc;

    @Column(name = "USUARIO", length = 20)
    private String usuario;

    @Column(name = "FEC_EJEC_INI")
    private java.time.LocalDateTime fecEjecIni;

    @Column(name = "FEC_EJEC_FIN")
    private java.time.LocalDateTime fecEjecFin;

    @Column(name = "RESULT_PROCESO", length = 15)
    private String resultProceso;

    @Column(name = "NOM_ARCHIVO_CG", length = 50)
    private String nomArchivoCg;

    @Column(name = "COD_FALLO", length = 50)
    private String codFallo;

    @Column(name = "CAUSA_FALLO")
    private String causaFallo;

    @Column(name = "NRO_REG_LEIDOS_PROC", length = 10)
    private java.math.BigDecimal nroRegLeidosProc;

    @Column(name = "NRO_REG_FALLO", length = 10)
    private java.math.BigDecimal nroRegFallo;

    @Column(name = "DIR_IP", length = 20)
    private String dirIp;

}
