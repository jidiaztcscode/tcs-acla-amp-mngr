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
@Table(name = "estructura_cupon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class estructuraCupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ConsecutivoCupon")
    private Integer consecutivocupon;

    @Column(name = "PeriodoNomina", length = 6)
    private String periodonomina;

    @Column(name = "Numero_Cuenta")
    private Long numeroCuenta;

    @Column(name = "TipoRegistro")
    private Integer tiporegistro;

    @Column(name = "FechadeEnvio")
    private java.time.LocalDateTime fechadeenvio;

    @Column(name = "ValorRegistro")
    private String valorregistro;

    @Column(name = "EnviadoDoc1", length = 1)
    private String enviadodoc1;

    @Column(name = "Id_Archivo_Cupon", length = 20)
    private String idArchivoCupon;

}
