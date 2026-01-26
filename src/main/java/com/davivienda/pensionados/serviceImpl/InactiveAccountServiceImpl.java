package com.davivienda.pensionados.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davivienda.pensionados.dto.InactiveAccountDTO;
import com.davivienda.pensionados.model.InactiveAccount;
import com.davivienda.pensionados.repository.InactiveAccountRepository;
import com.davivienda.pensionados.service.InactiveAccountService;

@Service
public class InactiveAccountServiceImpl implements InactiveAccountService {

    @Autowired
    private InactiveAccountRepository repository;

    @Override
    public List<InactiveAccountDTO> getInactiveAccounts(
            LocalDate startDate,
            LocalDate endDate,
            String companyNIT,
            String idNumber,
            String employerAccount
    ) {
    List<InactiveAccount> accounts = repository.findByFilters(
        startDate, endDate, companyNIT, idNumber, employerAccount
    );

        if (accounts.isEmpty()) {
            throw new RuntimeException("No results found for the given search criteria.");
        }

        return accounts.stream().map(account -> {
            InactiveAccountDTO dto = new InactiveAccountDTO();
            dto.setPensionerName(account.getPensionerName());
            dto.setIdNumber(account.getIdNumber());
            dto.setIdType(account.getIdType());
            dto.setAccount(account.getAccount());
            dto.setAccountOpeningDate(account.getAccountOpeningDate());
            dto.setLastWithdrawalDate(account.getLastWithdrawalDate());
            dto.setLastPaymentDate(account.getLastPaymentDate());
            dto.setEmployerAccount(account.getEmployerAccount());
            dto.setCompanyName(account.getCompanyName());
            dto.setCompanyNIT(account.getCompanyNIT());
            dto.setTotalValueOfAllowances(account.getTotalValueOfAllowances());
            dto.setInactivityDate(account.getInactivityDate());
            return dto;
        }).collect(Collectors.toList());
    }
}