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
@Table(name = "cupon_pensionado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cuponPensionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo_Registro")
    private Integer tipoRegistro;

    @Column(name = "Numero_Cupon")
    private Integer numeroCupon;

    @Column(name = "Tipo_Documento", length = 2)
    private String tipoDocumento;

    @Column(name = "Numero_Documento_Pensionado")
    private Long numeroDocumentoPensionado;

    @Column(name = "Primer_Apellido", length = 15)
    private String primerApellido;

    @Column(name = "Segundo_Apellido", length = 15)
    private String segundoApellido;

    @Column(name = "Primer_Nombre", length = 15)
    private String primerNombre;

    @Column(name = "Segundo_Nombre", length = 15)
    private String segundoNombre;

    @Column(name = "Codigo_Sucursal_Bancaria")
    private Integer codigoSucursalBancaria;

    @Column(name = "Nombre_Sucursal_Bancaria", length = 25)
    private String nombreSucursalBancaria;

    @Column(name = "Numero_Cuenta")
    private Long numeroCuenta;

    @Column(name = "Direccion_Bancaria", length = 45)
    private String direccionBancaria;

    @Column(name = "Codigo_Departamento_Bancaria")
    private Integer codigoDepartamentoBancaria;

    @Column(name = "Nombre_Departamento_Bancaria", length = 50)
    private String nombreDepartamentoBancaria;

    @Column(name = "Codigo_CiudadMunicipio_Bancaria")
    private Integer codigoCiudadmunicipioBancaria;

    @Column(name = "Nombre_CiudadMunicipio_Bancaria", length = 50)
    private String nombreCiudadmunicipioBancaria;

    @Column(name = "PeriodoNomina")
    private Integer periodonomina;

    @Column(name = "ConsecutivoCupon")
    private Integer consecutivocupon;

    @Column(name = "Id_Archivo_Cupon", length = 20)
    private String idArchivoCupon;

}
