package com.davivienda.pensionados.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.InactiveAccount;

@Repository
public interface InactiveAccountRepository extends JpaRepository<InactiveAccount, Long> {

    List<InactiveAccount> findByInactivityDateBetweenAndCompanyNITAndIdNumberAndEmployerAccount(
            LocalDate startDate,
            LocalDate endDate,
            String companyNIT,
            String idNumber,
            String employerAccount
    );
}