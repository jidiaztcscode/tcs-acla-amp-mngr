package com.davivienda.pensionados.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.InactiveAccount;

@Repository
public interface InactiveAccountRepository extends JpaRepository<InactiveAccount, Long> {

    @Query("SELECT ia FROM InactiveAccount ia WHERE ia.inactivityDate BETWEEN :startDate AND :endDate"
         + " AND (:companyNIT IS NULL OR ia.companyNIT = :companyNIT)"
         + " AND (:idNumber IS NULL OR ia.idNumber = :idNumber)"
         + " AND (:employerAccount IS NULL OR ia.employerAccount = :employerAccount)")
    List<InactiveAccount> findByFilters(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("companyNIT") String companyNIT,
            @Param("idNumber") String idNumber,
            @Param("employerAccount") String employerAccount
    );
}