package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.transRepDetvista;

@Repository
public interface TransRepDetvistaRepository extends JpaRepository<transRepDetvista, Long> {
    List<transRepDetvista> findByIdvista(BigDecimal idvista);
}
