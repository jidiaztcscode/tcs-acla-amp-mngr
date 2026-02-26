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
@Table(name = "temp_novedades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempNovedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "num_cuenta", length = 16)
    private java.math.BigDecimal numCuenta;

    @Column(name = "num_afiliacion_1", length = 12)
    private java.math.BigDecimal numAfiliacion1;

    @Column(name = "num_afiliacion_2", length = 12)
    private java.math.BigDecimal numAfiliacion2;

    @Column(name = "TipoIdentificacion", length = 2)
    private java.math.BigDecimal tipoidentificacion;

    @Column(name = "NumeroIdentificacion", length = 16)
    private java.math.BigDecimal numeroidentificacion;

    @Column(name = "NombresTitular", length = 30)
    private String nombrestitular;

    @Column(name = "PrimerApellido", length = 20)
    private String primerapellido;

    @Column(name = "SegundoApellido", length = 20)
    private String segundoapellido;

    @Column(name = "Sexo", length = 1)
    private String sexo;

    @Column(name = "ActividadEconomica", length = 5)
    private java.math.BigDecimal actividadeconomica;

    @Column(name = "Subproducto", length = 4)
    private java.math.BigDecimal subproducto;

    @Column(name = "ClaseCuenta", length = 2)
    private java.math.BigDecimal clasecuenta;

    @Column(name = "TipoCuentaPagador", length = 2)
    private java.math.BigDecimal tipocuentapagador;

    @Column(name = "CuentaPagador", length = 16)
    private java.math.BigDecimal cuentapagador;

    @Column(name = "NITPagador", length = 10)
    private java.math.BigDecimal nitpagador;

    @Column(name = "NombrePagador", length = 40)
    private String nombrepagador;

    @Column(name = "TipoMoneda", length = 2)
    private java.math.BigDecimal tipomoneda;

    @Column(name = "IndicadorObjetivo", length = 2)
    private java.math.BigDecimal indicadorobjetivo;

    @Column(name = "Direccion", length = 40)
    private String direccion;

    @Column(name = "Ciudad", length = 11)
    private java.math.BigDecimal ciudad;

    @Column(name = "Telefono", length = 18)
    private java.math.BigDecimal telefono;

    @Column(name = "TipoCliente", length = 1)
    private String tipocliente;

    @Column(name = "Declarante", length = 2)
    private java.math.BigDecimal declarante;

    @Column(name = "CodigoCompania", length = 2)
    private java.math.BigDecimal codigocompania;

    @Column(name = "IndicadorNoDeseado", length = 3)
    private String indicadornodeseado;

    @Column(name = "Novedad", length = 1)
    private String novedad;

    @Column(name = "MedioApertura", length = 2)
    private java.math.BigDecimal medioapertura;

    @Column(name = "Fecha_Novedad")
    private java.time.LocalDateTime fechaNovedad;

    @Column(name = "Estado", length = 20)
    private String estado;

    @Column(name = "cod_error", length = 20)
    private String codError;

    @Column(name = "MSJE_ERROR", length = 200)
    private String msjeError;

    @Column(name = "TipoCuentaPensionado", length = 2)
    private String tipocuentapensionado;

    @Column(name = "PrimerNombre", length = 15)
    private String primernombre;

    @Column(name = "SegundoNombre", length = 15)
    private String segundonombre;

    @Column(name = "TipoAperturaCuenta", length = 2)
    private String tipoaperturacuenta;

}
