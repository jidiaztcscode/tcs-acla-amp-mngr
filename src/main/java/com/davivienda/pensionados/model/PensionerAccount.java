package com.davivienda.pensionados.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pensioner_accounts")
public class PensionerAccount {
    @Id
    private Long id;
    private String identificationNumber;
    private String idType;
    private String pensionerName;
    private String openingOffice;
    private String account;
    private String accountStatement;
    private LocalDate openingDate;
    private String transactionalMeans;
    private String objective;
    private String employerAccount;
    private String companyNIT;
    private String companyName;
}