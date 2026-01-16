package com.davivienda.pensionados.serviceImpl;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davivienda.pensionados.model.ProcessLog;
import com.davivienda.pensionados.repository.ProcessLogRepository;
import com.davivienda.pensionados.service.ProcessLogService;

@Service
public class ProcessLogServiceImpl implements ProcessLogService {

    @Autowired
    private ProcessLogRepository processLogRepository;

    @Override
    public List<ProcessLog> getProcessLogs(LocalDate startDate, LocalDate endDate) {
        return processLogRepository.findByStartDateBetweenAndEndDateBetween(startDate, endDate, startDate, endDate);
    }

    @Override
    public ProcessLog saveProcessLog(ProcessLog processLog) {
        return processLogRepository.save(processLog);
    }
}