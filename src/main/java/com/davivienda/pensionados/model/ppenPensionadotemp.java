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
@Table(name = "ppen_pensionadotemp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ppenPensionadotemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NumeroIdPensionadoTemp", length = 16)
    private java.math.BigDecimal numeroidpensionadotemp;

    @Column(name = "FechaFallecimientoTemp")
    private java.time.LocalDateTime fechafallecimientotemp;

    @Column(name = "FechaFallecimientoPreReinTemp")
    private java.time.LocalDateTime fechafallecimientoprereintemp;

    @Column(name = "USU_MOD_APPTemp", length = 50)
    private String usuModApptemp;

    @Column(name = "FEC_MOD_APPTemp")
    private java.time.LocalDateTime fecModApptemp;

    @Column(name = "IdReintegro", length = 16)
    private java.math.BigDecimal idreintegro;

    @Column(name = "NumeroCuentaPensionado", length = 20)
    private java.math.BigDecimal numerocuentapensionado;

}
