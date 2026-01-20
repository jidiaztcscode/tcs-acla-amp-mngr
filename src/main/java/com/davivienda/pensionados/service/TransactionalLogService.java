package com.davivienda.pensionados.service;


import java.time.LocalDate;
import java.util.List;

import com.davivienda.pensionados.model.TransactionalLog;

public interface TransactionalLogService {
    List<TransactionalLog> getTransactionalLogs(LocalDate startDate, LocalDate endDate);
    TransactionalLog saveTransactionalLog(TransactionalLog transactionalLog);
}