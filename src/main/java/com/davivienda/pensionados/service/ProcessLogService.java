package com.davivienda.pensionados.service;


import java.time.LocalDate;
import java.util.List;

import com.davivienda.pensionados.model.ProcessLog;

public interface ProcessLogService {
    List<ProcessLog> getProcessLogs(LocalDate startDate, LocalDate endDate);
    ProcessLog saveProcessLog(ProcessLog processLog);
}