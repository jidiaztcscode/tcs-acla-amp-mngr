package com.davivienda.pensionados.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.PensionerAccountReportFilter;
import com.davivienda.pensionados.model.PensionerAccount;
import com.davivienda.pensionados.service.PensionerAccountService;

@RestController
@RequestMapping("/api/reports")
public class PensionerAccountController {

    private final PensionerAccountService service;

    public PensionerAccountController(PensionerAccountService service) {
        this.service = service;
    }

    @PostMapping("/pensioner-accounts")
    public ResponseEntity<List<PensionerAccount>> getPensionerAccountReport(@RequestBody PensionerAccountReportFilter filter) {
        List<PensionerAccount> report = service.getPensionerAccountReport(filter);
        return ResponseEntity.ok(report);
    }
}