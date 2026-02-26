package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.transRepDetconsulta;

@Repository
public interface TransRepDetconsultaRepository extends JpaRepository<transRepDetconsulta, Long> {
    List<transRepDetconsulta> findByIdconsulta(BigDecimal idconsulta);
    void deleteByIdconsulta(BigDecimal idconsulta);
}
