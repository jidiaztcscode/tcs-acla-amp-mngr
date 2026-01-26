package com.davivienda.pensionados.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "file_upload_logs")
public class FileUploadLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "records_read")
    private Integer recordsRead;

    @Column(name = "records_processed")
    private Integer recordsProcessed;

    @Column(name = "records_failed")
    private Integer recordsFailed;

    @Column(name = "upload_date")
    private LocalDate uploadDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public String getFileName() {
        return fileName;
    }
    public Integer getRecordsRead() {
        return recordsRead;
    }
    public Integer getRecordsProcessed() {
        return recordsProcessed;
    }
    public Integer getRecordsFailed() {
        return recordsFailed;
    }
    public LocalDate getUploadDate() {
        return uploadDate;
    }

    
}