package com.davivienda.pensionados.dto;


import java.time.LocalDate;

import lombok.Data;

@Data
public class PensionerAccountReportFilter {
    private LocalDate openingDateStart;
    private LocalDate openingDateEnd;
    private String companyNIT;
    private String account;
    private String employerAccount;
    private String identificationNumber;
    private String idType;
}