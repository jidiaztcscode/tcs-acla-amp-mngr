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
@Table(name = "trans_rol_opcion_app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class transRolOpcionApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_APP_ROL_OPC", length = 10)
    private java.math.BigDecimal idAppRolOpc;

    @Column(name = "ID_ROL", length = 10)
    private java.math.BigDecimal idRol;

    @Column(name = "ID_OPCION", length = 10)
    private java.math.BigDecimal idOpcion;

}
