package com.davivienda.pensionados.serviceImpl;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davivienda.pensionados.model.TransactionalLog;
import com.davivienda.pensionados.repository.TransactionalLogRepository;
import com.davivienda.pensionados.service.TransactionalLogService;

@Service
public class TransactionalLogServiceImpl implements TransactionalLogService {

    @Autowired
    private TransactionalLogRepository transactionalLogRepository;

    @Override
    public List<TransactionalLog> getTransactionalLogs(LocalDate startDate, LocalDate endDate) {
        return transactionalLogRepository.findByStartDateBetweenAndEndDateBetween(startDate, endDate, startDate, endDate);
    }

    @Override
    public TransactionalLog saveTransactionalLog(TransactionalLog transactionalLog) {
        return transactionalLogRepository.save(transactionalLog);
    }
}