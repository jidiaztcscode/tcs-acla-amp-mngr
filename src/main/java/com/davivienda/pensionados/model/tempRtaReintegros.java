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
@Table(name = "temp_rta_reintegros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempRtaReintegros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "tipo_registro", length = 2)
    private String tipoRegistro;

    @Column(name = "nit_pensionado", length = 16)
    private java.math.BigDecimal nitPensionado;

    @Column(name = "nro_referencia", length = 16)
    private java.math.BigDecimal nroReferencia;

    @Column(name = "cuenta_destino", length = 16)
    private java.math.BigDecimal cuentaDestino;

    @Column(name = "tip_cuenta_destino", length = 2)
    private String tipCuentaDestino;

    @Column(name = "cod_banco_destino", length = 6)
    private java.math.BigDecimal codBancoDestino;

    @Column(name = "valor_traslado", length = 18)
    private java.math.BigDecimal valorTraslado;

    @Column(name = "nro_talon", length = 6)
    private java.math.BigDecimal nroTalon;

    @Column(name = "tip_ident_destino", length = 2)
    private java.math.BigDecimal tipIdentDestino;

    @Column(name = "validar_ident", length = 1)
    private java.math.BigDecimal validarIdent;

    @Column(name = "respuesta_traslado", length = 4)
    private java.math.BigDecimal respuestaTraslado;

    @Column(name = "mensaje", length = 40)
    private String mensaje;

    @Column(name = "filler", length = 18)
    private java.math.BigDecimal filler;

    @Column(name = "fech_aplicacion", length = 8)
    private java.math.BigDecimal fechAplicacion;

    @Column(name = "oficina_rec_det", length = 4)
    private java.math.BigDecimal oficinaRecDet;

    @Column(name = "motivo_det", length = 4)
    private java.math.BigDecimal motivoDet;

    @Column(name = "datos_adic", length = 7)
    private String datosAdic;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue")
    private String msjeErrorCargue;

    @Column(name = "tipo_reintegro", length = 2)
    private String tipoReintegro;

    @Column(name = "valor_reintegro", length = 16)
    private java.math.BigDecimal valorReintegro;

    @Column(name = "fecha_ultimo_retiro")
    private java.time.LocalDateTime fechaUltimoRetiro;

    @Column(name = "hora_ultimo_retiro", length = 5)
    private String horaUltimoRetiro;

}
