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
@Table(name = "cupon_encabezado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cuponEncabezado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo_Registro")
    private Integer tipoRegistro;

    @Column(name = "Codigo_Entidad_Bancaria")
    private Integer codigoEntidadBancaria;

    @Column(name = "Nombre_Entidad_Bancaria", length = 50)
    private String nombreEntidadBancaria;

    @Column(name = "Cantidad_Sucursales")
    private Integer cantidadSucursales;

    @Column(name = "Cantidad_Pensionados")
    private Integer cantidadPensionados;

    @Column(name = "Ano_Nomina")
    private Integer anoNomina;

    @Column(name = "Mes_Nomina")
    private Integer mesNomina;

    @Column(name = "Fecha_Vencimiento", length = 10)
    private String fechaVencimiento;

    @Column(name = "Mensaje_variable", length = 250)
    private String mensajeVariable;

    @Column(name = "ConsecutivoCupon")
    private Integer consecutivocupon;

    @Column(name = "Id_Archivo_Cupon", length = 20)
    private String idArchivoCupon;

    @Column(name = "Procesado", length = 2)
    private String procesado;

}
