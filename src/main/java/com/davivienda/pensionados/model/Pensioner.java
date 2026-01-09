package com.davivienda.pensionados.model;

public class Pensioner {
    private String idType;
    private String idNumber;
    private String accountNumber;
    private String affiliationNumber;
    private String payerNit;
    private String payerName;

    // Getters and Setters
    public String getIdType() { return idType; }
    public void setIdType(String idType) { this.idType = idType; }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAffiliationNumber() { return affiliationNumber; }
    public void setAffiliationNumber(String affiliationNumber) { this.affiliationNumber = affiliationNumber; }

    public String getPayerNit() { return payerNit; }
    public void setPayerNit(String payerNit) { this.payerNit = payerNit; }

    public String getPayerName() { return payerName; }
    public void setPayerName(String payerName) { this.payerName = payerName; }
	public Pensioner(String idType, String idNumber, String accountNumber, String affiliationNumber, String payerNit,
			String payerName) {
		super();
		this.idType = idType;
		this.idNumber = idNumber;
		this.accountNumber = accountNumber;
		this.affiliationNumber = affiliationNumber;
		this.payerNit = payerNit;
		this.payerName = payerName;
	}
}