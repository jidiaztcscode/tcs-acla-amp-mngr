package com.davivienda.pensionados.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.SecurityLog;

@Repository
public interface SecurityLogRepository extends JpaRepository<SecurityLog, Long> {
    List<SecurityLog> findByStartDateBetweenAndEndDateBetween(LocalDate startDate, LocalDate endDate, LocalDate startDate2, LocalDate endDate2);
}