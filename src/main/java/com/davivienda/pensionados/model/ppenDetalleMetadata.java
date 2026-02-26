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
@Table(name = "ppen_detalle_metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenDetalleMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_Detalle_met", length = 10)
    private java.math.BigDecimal idDetalleMet;

    @Column(name = "CodDavivienda", length = 50)
    private String coddavivienda;

    @Column(name = "CodEstandar", length = 50)
    private String codestandar;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "Estado", length = 1)
    private String estado;

    @Column(name = "Id_metadata", length = 10)
    private java.math.BigDecimal idMetadata;

    @Column(name = "ID_detalle_padre", length = 10)
    private java.math.BigDecimal idDetallePadre;

    @Column(name = "Flag_tipo_dato", length = 1)
    private String flagTipoDato;

    @Column(name = "Descripcion2", length = 100)
    private String descripcion2;

}
