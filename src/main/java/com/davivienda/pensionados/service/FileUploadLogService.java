package com.davivienda.pensionados.service;


import java.time.LocalDate;
import java.util.List;

import com.davivienda.pensionados.model.FileUploadLog;

public interface FileUploadLogService {
    List<FileUploadLog> getFileUploadLogs(LocalDate startDate, LocalDate endDate);
    FileUploadLog saveFileUploadLog(FileUploadLog fileUploadLog);
}