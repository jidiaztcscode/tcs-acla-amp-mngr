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
@Table(name = "parametroempresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class parametroempresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nit", length = 16)
    private java.math.BigDecimal nit;

    @Column(name = "Nombre", length = 70)
    private String nombre;

    @Column(name = "NumeroCuentaEmpresa", length = 16)
    private java.math.BigDecimal numerocuentaempresa;

    @Column(name = "AprobacionAutomatica", length = 2)
    private String aprobacionautomatica;

    @Column(name = "UsuarioCreacion", length = 50)
    private String usuariocreacion;

    @Column(name = "FechaCreacion")
    private java.time.LocalDateTime fechacreacion;

    @Column(name = "UsuarioModificacion", length = 50)
    private String usuariomodificacion;

    @Column(name = "FechaModificacion")
    private java.time.LocalDateTime fechamodificacion;

}
