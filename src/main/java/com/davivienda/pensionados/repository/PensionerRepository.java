package com.davivienda.pensionados.repository;


import java.util.List;

import com.davivienda.pensionados.model.Pensioner;

public interface PensionerRepository {
    Pensioner findByIdNumber(String idNumber);
    List<Pensioner> findByAccountNumber(String accountNumber);
    void save(Pensioner pensioner);
    void update(Pensioner pensioner);
}