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
@Table(name = "trans_accion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class transAccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ACCION", length = 10)
    private java.math.BigDecimal idAccion;

    @Column(name = "NOMBRE_ACCION", length = 100)
    private String nombreAccion;

    @Column(name = "CONTROLADOR", length = 100)
    private String controlador;

    @Column(name = "TIPO_ACCION", length = 25)
    private String tipoAccion;

    @Column(name = "TIPO_LOG", length = 25)
    private String tipoLog;

}
