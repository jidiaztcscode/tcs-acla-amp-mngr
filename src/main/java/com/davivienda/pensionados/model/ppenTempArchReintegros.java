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
@Table(name = "ppen_temp_arch_reintegros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenTempArchReintegros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "IdTempReintegro", length = 10)
    private java.math.BigDecimal idtempreintegro;

    @Column(name = "NumeroReintegro", length = 10)
    private java.math.BigDecimal numeroreintegro;

    @Column(name = "NumeroCuentaPensionado", length = 20)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "FechaFallece")
    private java.time.LocalDateTime fechafallece;

    @Column(name = "validacion")
    private String validacion;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue")
    private String msjeErrorCargue;

    @Column(name = "ClaseReintegro", length = 2)
    private String clasereintegro;

    @Column(name = "FechaONP")
    private java.time.LocalDateTime fechaonp;

    @Column(name = "Valor_Neto", length = 12)
    private java.math.BigDecimal valorNeto;

    @Column(name = "Tipo_Documento", length = 2)
    private String tipoDocumento;

    @Column(name = "Numero_Documento", length = 15)
    private String numeroDocumento;

    @Column(name = "Primer_Apellido", length = 15)
    private String primerApellido;

    @Column(name = "Segundo_Apellido", length = 15)
    private String segundoApellido;

    @Column(name = "Primer_Nombre", length = 15)
    private String primerNombre;

    @Column(name = "Segundo_Nombre", length = 15)
    private String segundoNombre;

    @Column(name = "Periodo_Nomina", length = 6)
    private java.math.BigDecimal periodoNomina;

    @Column(name = "Referencia", length = 50)
    private String referencia;

    @Column(name = "Banco", length = 2)
    private java.math.BigDecimal banco;

    @Column(name = "Sucursal", length = 4)
    private java.math.BigDecimal sucursal;

    @Column(name = "Tipo_Cuenta", length = 2)
    private String tipoCuenta;

    @Column(name = "Estado_Pago", length = 1)
    private java.math.BigDecimal estadoPago;

    @Column(name = "Descripcion_No_Pago", length = 150)
    private String descripcionNoPago;

}
