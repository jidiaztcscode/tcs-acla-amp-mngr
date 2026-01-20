package com.davivienda.pensionados.service;


import java.time.LocalDate;
import java.util.List;

import com.davivienda.pensionados.dto.InactiveAccountDTO;

public interface InactiveAccountService {

    List<InactiveAccountDTO> getInactiveAccounts(
            LocalDate startDate,
            LocalDate endDate,
            String companyNIT,
            String idNumber,
            String employerAccount
    );
}