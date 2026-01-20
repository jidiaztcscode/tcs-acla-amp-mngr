package com.davivienda.pensionados.controller;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.InactiveAccountDTO;
import com.davivienda.pensionados.service.InactiveAccountService;

import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/reports")
public class InactiveAccountController {

    @Autowired
    private InactiveAccountService service;

    @GetMapping("/inactive-accounts")
    public List<InactiveAccountDTO> getInactiveAccounts(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            @RequestParam(required = false) String companyNIT,
            @RequestParam(required = false) @Size(min = 3, max = 16, message = "The length of the ID number field must be a minimum of 3 and a maximum of 16 digits.") String idNumber,
            @RequestParam(required = false) @Size(min = 16, max = 16, message = "The length of the Employer Account field must be 16 digits.") String employerAccount
    ) {
        // Validate that the start date is not after the end date
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("The start date cannot be longer than the end date.");
        }

        // Call the service to fetch the inactive accounts
        return service.getInactiveAccounts(startDate, endDate, companyNIT, idNumber, employerAccount);
    }
}
