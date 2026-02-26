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
@Table(name = "temp_cupon_movimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempCuponMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TipoRegistro")
    private Integer tiporegistro;

    @Column(name = "TipoDocumento", length = 2)
    private String tipodocumento;

    @Column(name = "NroDocumento")
    private Long nrodocumento;

    @Column(name = "TipoMovimiento")
    private Integer tipomovimiento;

    @Column(name = "CodigoConcepto")
    private Integer codigoconcepto;

    @Column(name = "NombreConcepto", length = 40)
    private String nombreconcepto;

    @Column(name = "ValorConcepto")
    private Integer valorconcepto;

    @Column(name = "PeriodoNomina")
    private Integer periodonomina;

    @Column(name = "ConsecutivoCupon")
    private Integer consecutivocupon;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_Cargue", length = 20)
    private String msjeErrorCargue;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "Id_Archivo_Cupon", length = 20)
    private String idArchivoCupon;

}
