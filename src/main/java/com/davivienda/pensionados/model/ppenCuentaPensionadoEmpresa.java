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
@Table(name = "ppen_cuenta_pensionado_empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenCuentaPensionadoEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "NumeroIdEmpresa", length = 16)
    private java.math.BigDecimal numeroidempresa;

    @Column(name = "NumeroCuentaEmpresa", length = 16)
    private java.math.BigDecimal numerocuentaempresa;

    @Column(name = "TipoCuenta", length = 10)
    private java.math.BigDecimal tipocuenta;

    //@Column(name = "NumeroIdEmpresa", length = 16)
    //private java.math.BigDecimal numeroidempresa;

}
