package com.davivienda.pensionados.serviceImpl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.davivienda.pensionados.dto.PensionerAccountReportFilter;
import com.davivienda.pensionados.model.PensionerAccount;
import com.davivienda.pensionados.repository.PensionerAccountRepository;
import com.davivienda.pensionados.service.PensionerAccountService;

@Service
public class PensionerAccountServiceImpl implements PensionerAccountService {

    private final PensionerAccountRepository repository;

    public PensionerAccountServiceImpl(PensionerAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PensionerAccount> getPensionerAccountReport(PensionerAccountReportFilter filter) {
        return repository.findByOpeningDateBetweenAndCompanyNITContainingAndAccountContainingAndEmployerAccountContainingAndIdentificationNumberContainingAndIdTypeContaining(
                filter.getOpeningDateStart(),
                filter.getOpeningDateEnd(),
                filter.getCompanyNIT() != null ? filter.getCompanyNIT() : "",
                filter.getAccount() != null ? filter.getAccount() : "",
                filter.getEmployerAccount() != null ? filter.getEmployerAccount() : "",
                filter.getIdentificationNumber() != null ? filter.getIdentificationNumber() : "",
                filter.getIdType() != null ? filter.getIdType() : ""
        );
    }
}