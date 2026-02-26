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
@Table(name = "temp_cuentas_mig")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempCuentasMig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "CuentaDavivienda", length = 16)
    private java.math.BigDecimal cuentadavivienda;

    @Column(name = "CuentaBancafe", length = 16)
    private java.math.BigDecimal cuentabancafe;

    @Column(name = "NumeroIdentificacion", length = 16)
    private java.math.BigDecimal numeroidentificacion;

    @Column(name = "TipoIdentificacion", length = 2)
    private java.math.BigDecimal tipoidentificacion;

    @Column(name = "Vigencia", length = 1)
    private String vigencia;

    @Column(name = "SubProducto", length = 4)
    private java.math.BigDecimal subproducto;

    @Column(name = "FechaAperturaCuenta")
    private java.time.LocalDateTime fechaaperturacuenta;

    @Column(name = "FechaUltimoMovimiento", length = 8)
    private String fechaultimomovimiento;

    @Column(name = "NombrePersonal", length = 30)
    private String nombrepersonal;

    @Column(name = "ApellidoPersonal", length = 40)
    private String apellidopersonal;

    @Column(name = "ProvinciaPersonal", length = 11)
    private String provinciapersonal;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue", length = 200)
    private String msjeErrorCargue;

}
