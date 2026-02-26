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
@Table(name = "ppen_detalle_reintegro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenDetalleReintegro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IdDetalleReintegro", length = 10)
    private java.math.BigDecimal iddetallereintegro;

    @Column(name = "NumeroPago", length = 10)
    private java.math.BigDecimal numeropago;

    @Column(name = "CodigoRespuesta", length = 10)
    private java.math.BigDecimal codigorespuesta;

    @Column(name = "MensajeRespuesta", length = 100)
    private String mensajerespuesta;

    @Column(name = "NumeroReintegro", length = 10)
    private java.math.BigDecimal numeroreintegro;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "IdTempReintegro", length = 10)
    private java.math.BigDecimal idtempreintegro;

}
