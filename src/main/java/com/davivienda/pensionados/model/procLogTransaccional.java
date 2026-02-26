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
@Table(name = "proc_log_transaccional")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procLogTransaccional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_LOG_TRANS", length = 10)
    private java.math.BigDecimal idLogTrans;

    @Column(name = "USUARIO", length = 20)
    private String usuario;

    @Column(name = "FEC_EJEC_INI")
    private java.time.LocalDateTime fecEjecIni;

    @Column(name = "NRO_PRODUCTO", length = 50)
    private String nroProducto;

    @Column(name = "RESULT_PROCESO", length = 15)
    private String resultProceso;

    @Column(name = "COD_FALLO", length = 50)
    private String codFallo;

    @Column(name = "CAUSA_FALLO")
    private String causaFallo;

    @Column(name = "ORIGEN_EVENTO", length = 50)
    private String origenEvento;

    @Column(name = "TIPO_EVENTO", length = 30)
    private String tipoEvento;

    @Column(name = "DATO_ANTERIOR")
    private String datoAnterior;

    @Column(name = "DATO_NUEVO")
    private String datoNuevo;

    @Column(name = "NOMBRE_CAMPO")
    private String nombreCampo;

    @Column(name = "DIR_IP", length = 20)
    private String dirIp;

    @Column(name = "HOSTNAME", length = 50)
    private String hostname;

    @Column(name = "NRO_TELEFONO", length = 20)
    private String nroTelefono;

    @Column(name = "NRO_OPERACION", length = 10)
    private java.math.BigDecimal nroOperacion;

    @Column(name = "COSTO_TRAN_USU", length = 12)
    private java.math.BigDecimal costoTranUsu;

    @Column(name = "IDEN_USU_CONSULTA", length = 20)
    private String idenUsuConsulta;

    @Column(name = "CANAL_UTILIZADO", length = 50)
    private String canalUtilizado;

    @Column(name = "NOM_APLICACION", length = 50)
    private String nomAplicacion;

}
