package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.transRepConsulta;

@Repository
public interface TransRepConsultaRepository extends JpaRepository<transRepConsulta, Long> {
    Optional<transRepConsulta> findByIdconsulta(BigDecimal idconsulta);
}
