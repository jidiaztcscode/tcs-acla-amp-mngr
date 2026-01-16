package com.davivienda.pensionados.service;


import java.time.LocalDate;
import java.util.List;

import com.davivienda.pensionados.model.SecurityLog;

public interface SecurityLogService {
    List<SecurityLog> getSecurityLogs(LocalDate startDate, LocalDate endDate);
    SecurityLog saveSecurityLog(SecurityLog securityLog);
}