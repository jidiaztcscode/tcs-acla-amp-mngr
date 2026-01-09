package com.davivienda.pensionados.dto;


import java.io.Serializable;

public class PensionerDTO implements Serializable {
    private static final long serialVersionUID = 1L; // Added serialVersionUID

    private String idType;
    private String idNumber;
    private String accountNumber;
    private String affiliationNumber;
    private String payerNit;
    private String payerName;

    // Default Constructor
    public PensionerDTO() {
    }

    // Parameterized Constructor
    public PensionerDTO(String idType, String idNumber, String accountNumber, String affiliationNumber, String payerNit, String payerName) {
        this.idType = idType;
        this.idNumber = idNumber;
        this.accountNumber = accountNumber;
        this.affiliationNumber = affiliationNumber;
        this.payerNit = payerNit;
        this.payerName = payerName;
    }

    // Getters and Setters
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAffiliationNumber() {
        return affiliationNumber;
    }

    public void setAffiliationNumber(String affiliationNumber) {
        this.affiliationNumber = affiliationNumber;
    }

    public String getPayerNit() {
        return payerNit;
    }

    public void setPayerNit(String payerNit) {
        this.payerNit = payerNit;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    // toString Method for Debugging
    @Override
    public String toString() {
        return "PensionerDTO{" +
                "idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", affiliationNumber='" + affiliationNumber + '\'' +
                ", payerNit='" + payerNit + '\'' +
                ", payerName='" + payerName + '\'' +
                '}';
    }
}