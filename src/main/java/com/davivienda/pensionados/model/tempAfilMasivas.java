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
@Table(name = "temp_afil_masivas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tempAfilMasivas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CARGUE", length = 10)
    private java.math.BigDecimal idCargue;

    @Column(name = "TIPO_IDENTIFICACION", length = 2)
    private String tipoIdentificacion;

    @Column(name = "NUMERO_IDENTIFICACION", length = 16)
    private java.math.BigDecimal numeroIdentificacion;

    @Column(name = "NRO_CTA_PENSIONADO", length = 16)
    private java.math.BigDecimal nroCtaPensionado;

    @Column(name = "NRO_AFILIACION_INICIAL", length = 16)
    private java.math.BigDecimal nroAfiliacionInicial;

    @Column(name = "NRO_AFILIACION_NUEVA", length = 16)
    private java.math.BigDecimal nroAfiliacionNueva;

    @Column(name = "NIT_PAGADOR", length = 10)
    private java.math.BigDecimal nitPagador;

    @Column(name = "FLAG_CREA_EMP", length = 1)
    private String flagCreaEmp;

    @Column(name = "Estado_cargue", length = 20)
    private String estadoCargue;

    @Column(name = "cod_error_cargue", length = 20)
    private String codErrorCargue;

    @Column(name = "MSJE_ERROR_cargue")
    private String msjeErrorCargue;

    @Column(name = "Usuario", length = 50)
    private String usuario;

}
