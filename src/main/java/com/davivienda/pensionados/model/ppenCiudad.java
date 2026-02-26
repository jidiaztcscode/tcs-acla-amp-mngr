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
@Table(name = "ppen_ciudad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COD_MUNICIPIO", length = 11)
    private java.math.BigDecimal codMunicipio;

    @Column(name = "NOM_MUNICIPIO", length = 100)
    private String nomMunicipio;

    @Column(name = "COD_DAVIVIENDA", length = 15)
    private String codDavivienda;

}
