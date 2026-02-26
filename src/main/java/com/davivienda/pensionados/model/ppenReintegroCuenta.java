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
@Table(name = "ppen_reintegro_cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenReintegroCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroReintegro", length = 10)
    private java.math.BigDecimal numeroreintegro;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "TipoReintegro", length = 2)
    private String tiporeintegro;

    @Column(name = "ValorNeto", length = 12)
    private java.math.BigDecimal valorneto;

    @Column(name = "FechaFallece")
    private java.time.LocalDateTime fechafallece;

    @Column(name = "FechaONP")
    private java.time.LocalDateTime fechaonp;

    @Column(name = "FechaUltimoRetiro")
    private java.time.LocalDateTime fechaultimoretiro;

    @Column(name = "HoraUltimoRetiro", length = 5)
    private String horaultimoretiro;

}
