package com.davivienda.pensionados.serviceImpl;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davivienda.pensionados.model.SecurityLog;
import com.davivienda.pensionados.repository.SecurityLogRepository;
import com.davivienda.pensionados.service.SecurityLogService;

@Service
public class SecurityLogServiceImpl implements SecurityLogService {

    @Autowired
    private SecurityLogRepository securityLogRepository;

    @Override
    public List<SecurityLog> getSecurityLogs(LocalDate startDate, LocalDate endDate) {
        return securityLogRepository.findByStartDateBetweenAndEndDateBetween(startDate, endDate, startDate, endDate);
    }

    @Override
    public SecurityLog saveSecurityLog(SecurityLog securityLog) {
        return securityLogRepository.save(securityLog);
    }
}