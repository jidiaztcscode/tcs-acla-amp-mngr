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
@Table(name = "cupon_control")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cuponControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TipoRegistro")
    private Integer tiporegistro;

    @Column(name = "TipoDocumento", length = 2)
    private String tipodocumento;

    @Column(name = "NroDocumento")
    private Long nrodocumento;

    @Column(name = "ValorDevengos")
    private Long valordevengos;

    @Column(name = "ValorDeducidos")
    private Long valordeducidos;

    @Column(name = "ValorNeto")
    private Long valorneto;

    @Column(name = "MensajePersonalizado", length = 250)
    private String mensajepersonalizado;

    @Column(name = "PeriodoNomina")
    private Integer periodonomina;

    @Column(name = "ConsecutivoCupon")
    private Integer consecutivocupon;

    @Column(name = "PROCESADA", length = 2)
    private String procesada;

    @Column(name = "Id_Archivo_Cupon", length = 20)
    private String idArchivoCupon;

}
