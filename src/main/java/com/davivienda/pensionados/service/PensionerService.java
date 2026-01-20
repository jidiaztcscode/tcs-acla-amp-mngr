package com.davivienda.pensionados.service;


import java.util.List;

import com.davivienda.pensionados.model.Pensioner;

public interface PensionerService {
    Pensioner findByIdNumber(String idNumber);
    List<Pensioner> findByAccountNumber(String accountNumber);
    void addAffiliation(String idNumber, String affiliationNumber, String payerNit);
    void modifyAffiliation(String idNumber, String newAffiliationNumber);
}