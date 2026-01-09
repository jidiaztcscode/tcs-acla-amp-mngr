package com.davivienda.pensionados.utils;


public class InputValidator {

    public static boolean isValidIdNumber(String idNumber) {
        return idNumber.matches("\\d{3,16}");
    }

    public static boolean isValidAffiliationNumber(String affiliationNumber) {
        return affiliationNumber.matches("\\d{12}");
    }

    public static boolean isValidPayerNit(String payerNit) {
        return payerNit.matches("\\d{3,16}");
    }
}
