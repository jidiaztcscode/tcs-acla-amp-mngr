package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.transRepFiltrocons;

@Repository
public interface TransRepFiltroconsRepository extends JpaRepository<transRepFiltrocons, Long> {
    List<transRepFiltrocons> findByIdconsultaOrderByOrdenAsc(BigDecimal idconsulta);
    void deleteByIdconsulta(BigDecimal idconsulta);
}
