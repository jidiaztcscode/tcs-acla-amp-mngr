package com.davivienda.pensionados.repository;


import java.util.ArrayList;
import java.util.List;

import com.davivienda.pensionados.model.Pensioner;

public class PensionerRepositoryImpl implements PensionerRepository {
    private List<Pensioner> pensioners = new ArrayList<>();

    @Override
    public Pensioner findByIdNumber(String idNumber) {
        return pensioners.stream()
                .filter(p -> p.getNumeroIdPensionado().equals(idNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Pensioner> findByAccountNumber(String accountNumber) {
        return pensioners.stream()
                .filter(p -> p.getNumeroIdPensionado().equals(accountNumber))
                .toList();
    }

    @Override
    public void save(Pensioner pensioner) {
        pensioners.add(pensioner);
    }

    @Override
    public void update(Pensioner pensioner) {
        // Update logic here
    }
}