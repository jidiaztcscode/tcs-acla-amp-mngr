package com.davivienda.pensionados.dto;



import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class InactiveAccountDTO {

    private String pensionerName;

    @NotNull(message = "ID number is required.")
    @Size(min = 3, max = 16, message = "The length of the ID number field must be a minimum of 3 and a maximum of 16 digits.")
    @Pattern(regexp = "\\d+", message = "ID number must contain only numeric characters.")
    private String idNumber;

    private String idType;
    private String account;
    private LocalDate accountOpeningDate;
    private LocalDate lastWithdrawalDate;
    private LocalDate lastPaymentDate;

    @Size(min = 16, max = 16, message = "The length of the Employer Account field must be 16 digits.")
    @Pattern(regexp = "\\d+", message = "Employer account must contain only numeric characters.")
    private String employerAccount;

    private String companyName;
    private String companyNIT;
    private Double totalValueOfAllowances;
    private LocalDate inactivityDate;


    // Getters and Setters
    public String getPensionerName() {
        return pensionerName;
    }

    public void setPensionerName(String pensionerName) {
        this.pensionerName = pensionerName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDate getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(LocalDate accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public LocalDate getLastWithdrawalDate() {
        return lastWithdrawalDate;
    }

    public void setLastWithdrawalDate(LocalDate lastWithdrawalDate) {
        this.lastWithdrawalDate = lastWithdrawalDate;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getEmployerAccount() {
        return employerAccount;
    }

    public void setEmployerAccount(String employerAccount) {
        this.employerAccount = employerAccount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNIT() {
        return companyNIT;
    }

    public void setCompanyNIT(String companyNIT) {
        this.companyNIT = companyNIT;
    }

    public Double getTotalValueOfAllowances() {
        return totalValueOfAllowances;
    }

    public void setTotalValueOfAllowances(Double totalValueOfAllowances) {
        this.totalValueOfAllowances = totalValueOfAllowances;
    }

    public LocalDate getInactivityDate() {
        return inactivityDate;
    }

    public void setInactivityDate(LocalDate inactivityDate) {
        this.inactivityDate = inactivityDate;
    }
}