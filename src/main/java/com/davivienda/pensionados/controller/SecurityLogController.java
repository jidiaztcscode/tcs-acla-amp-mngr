package com.davivienda.pensionados.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.model.SecurityLog;
import com.davivienda.pensionados.service.SecurityLogService;
import com.davivienda.pensionados.utils.DateValidator;

@RestController
@RequestMapping("/api/security-logs")
public class SecurityLogController {

    @Autowired
    private SecurityLogService securityLogService;

    @GetMapping
    public ResponseEntity<?> getSecurityLogs(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        if (!DateValidator.isStartDateBeforeEndDate(startDate, endDate)) {
            return ResponseEntity.badRequest().body("The start date cannot be later than the end date.");
        }

        List<SecurityLog> logs = securityLogService.getSecurityLogs(startDate, endDate);
        if (logs.isEmpty()) {
            return ResponseEntity.ok("No results found.");
        }

        return ResponseEntity.ok(logs);
    }

    @PostMapping
    public ResponseEntity<SecurityLog> saveSecurityLog(@RequestBody SecurityLog securityLog) {
        SecurityLog savedLog = securityLogService.saveSecurityLog(securityLog);
        return ResponseEntity.ok(savedLog);
    }
}
