package com.davivienda.pensionados.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.PensionerAccount;

@Repository
public interface PensionerAccountRepository extends JpaRepository<PensionerAccount, Long> {
    List<PensionerAccount> findByOpeningDateBetweenAndCompanyNITContainingAndAccountContainingAndEmployerAccountContainingAndIdentificationNumberContainingAndIdTypeContaining(
            LocalDate openingDateStart,
            LocalDate openingDateEnd,
            String companyNIT,
            String account,
            String employerAccount,
            String identificationNumber,
            String idType
    );
}