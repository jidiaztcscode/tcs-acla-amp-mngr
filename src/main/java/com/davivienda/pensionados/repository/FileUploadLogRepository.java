package com.davivienda.pensionados.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.FileUploadLog;

@Repository
public interface FileUploadLogRepository extends JpaRepository<FileUploadLog, Long> {
    List<FileUploadLog> findByUploadDateBetween(LocalDate startDate, LocalDate endDate);
}