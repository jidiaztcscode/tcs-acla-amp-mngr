package com.davivienda.pensionados.serviceImpl;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davivienda.pensionados.model.FileUploadLog;
import com.davivienda.pensionados.repository.FileUploadLogRepository;
import com.davivienda.pensionados.service.FileUploadLogService;

@Service
public class FileUploadLogServiceImpl implements FileUploadLogService {

    @Autowired
    private FileUploadLogRepository fileUploadLogRepository;

    @Override
    public List<FileUploadLog> getFileUploadLogs(LocalDate startDate, LocalDate endDate) {
        return fileUploadLogRepository.findByUploadDateBetween(startDate, endDate);
    }

    @Override
    public FileUploadLog saveFileUploadLog(FileUploadLog fileUploadLog) {
        return fileUploadLogRepository.save(fileUploadLog);
    }
}