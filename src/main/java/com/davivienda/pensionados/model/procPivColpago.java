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
@Table(name = "proc_piv_colpago")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class procPivColpago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUM_FILA", length = 18)
    private java.math.BigDecimal numFila;

    @Column(name = "DATOS")
    private String datos;

}
