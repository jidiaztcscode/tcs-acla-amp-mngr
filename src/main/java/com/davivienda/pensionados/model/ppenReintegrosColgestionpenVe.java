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
@Table(name = "ppen_reintegros_colgestionpen_ve")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenReintegrosColgestionpenVe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroReintegroOrigen", length = 10)
    private java.math.BigDecimal numeroreintegroorigen;

    @Column(name = "NumeroPago", length = 10)
    private java.math.BigDecimal numeropago;

    @Column(name = "NumeroReintegroCierre", length = 10)
    private java.math.BigDecimal numeroreintegrocierre;

    @Column(name = "EnviadoCOLGESTION", length = 2)
    private String enviadocolgestion;

}
