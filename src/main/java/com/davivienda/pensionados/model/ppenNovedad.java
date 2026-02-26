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
@Table(name = "ppen_novedad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenNovedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IdNovedad", length = 16)
    private java.math.BigDecimal idnovedad;

    @Column(name = "Tipo_Novedad", length = 10)
    private java.math.BigDecimal tipoNovedad;

    @Column(name = "FechaNovedad")
    private java.time.LocalDateTime fechanovedad;

    @Column(name = "NumeroCuentaPensionado", length = 16)
    private java.math.BigDecimal numerocuentapensionado;

    @Column(name = "USU_CREA_APP", length = 50)
    private String usuCreaApp;

    @Column(name = "FEC_CREACION")
    private java.time.LocalDateTime fecCreacion;

    @Column(name = "USU_MOD_APP", length = 50)
    private String usuModApp;

    @Column(name = "FEC_MOD_APP")
    private java.time.LocalDateTime fecModApp;

}
