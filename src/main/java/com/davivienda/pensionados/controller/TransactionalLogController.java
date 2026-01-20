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

import com.davivienda.pensionados.model.TransactionalLog;
import com.davivienda.pensionados.service.TransactionalLogService;
import com.davivienda.pensionados.utils.DateValidator;

@RestController
@RequestMapping("/api/transactional-logs")
public class TransactionalLogController {

    @Autowired
    private TransactionalLogService transactionalLogService;

    @GetMapping
    public ResponseEntity<?> getTransactionalLogs(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        if (!DateValidator.isStartDateBeforeEndDate(startDate, endDate)) {
            return ResponseEntity.badRequest().body("The start date cannot be later than the end date.");
        }

        List<TransactionalLog> logs = transactionalLogService.getTransactionalLogs(startDate, endDate);
        if (logs.isEmpty()) {
            return ResponseEntity.ok("No results found.");
        }

        return ResponseEntity.ok(logs);
    }

    @PostMapping
    public ResponseEntity<TransactionalLog> saveTransactionalLog(@RequestBody TransactionalLog transactionalLog) {
        TransactionalLog savedLog = transactionalLogService.saveTransactionalLog(transactionalLog);
        return ResponseEntity.ok(savedLog);
    }
}