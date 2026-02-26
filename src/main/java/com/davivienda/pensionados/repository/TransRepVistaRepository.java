package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.transRepVista;

@Repository
public interface TransRepVistaRepository extends JpaRepository<transRepVista, Long> {
    Optional<transRepVista> findByIdvista(BigDecimal idvista);
}
