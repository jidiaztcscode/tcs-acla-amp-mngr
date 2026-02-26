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
@Table(name = "proc_control_ejecucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procControlEjecucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDENCONTROL", length = 18)
    private java.math.BigDecimal idencontrol;

    @Column(name = "FECHAEJECUCION")
    private java.time.LocalDateTime fechaejecucion;

    @Column(name = "USUEJECUTA", length = 50)
    private String usuejecuta;

    @Column(name = "IDPROCESO", length = 18)
    private java.math.BigDecimal idproceso;

    @Column(name = "NOMARCHIVOPLANO", length = 100)
    private String nomarchivoplano;

    @Column(name = "CANT_RECIBIDOS", length = 10)
    private java.math.BigDecimal cantRecibidos;

    @Column(name = "CANT_CARGADOS", length = 10)
    private java.math.BigDecimal cantCargados;

    @Column(name = "CANT_INSTANCIADOS", length = 10)
    private java.math.BigDecimal cantInstanciados;

    @Column(name = "CANT_RECHAZADOS", length = 10)
    private java.math.BigDecimal cantRechazados;

}
