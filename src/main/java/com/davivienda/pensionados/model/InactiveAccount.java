package com.davivienda.pensionados.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "inactive_accounts")
public class InactiveAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pensioner_name", nullable = false)
    private String pensionerName;

    @Column(name = "id_number", nullable = false, length = 16)
    private String idNumber;

    @Column(name = "id_type", nullable = false)
    private String idType;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "account_opening_date")
    private LocalDate accountOpeningDate;

    @Column(name = "last_withdrawal_date")
    private LocalDate lastWithdrawalDate;

    @Column(name = "last_payment_date")
    private LocalDate lastPaymentDate;

    @Column(name = "employer_account", length = 16)
    private String employerAccount;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_nit", length = 16)
    private String companyNIT;

    @Column(name = "total_value_of_allowances")
    private Double totalValueOfAllowances;

    @Column(name = "inactivity_date")
    private LocalDate inactivityDate;

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

    // Getters and Setters
}