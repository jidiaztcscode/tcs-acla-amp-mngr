package com.davivienda.pensionados.serviceImpl;


import java.util.List;

import com.davivienda.pensionados.model.Pensioner;
import com.davivienda.pensionados.repository.PensionerRepository;
import com.davivienda.pensionados.repository.PensionerRepositoryImpl;
import com.davivienda.pensionados.service.PensionerService;
import com.davivienda.pensionados.utils.InputValidator;

import org.springframework.stereotype.Service;

@Service
public class PensionerServiceImpl implements PensionerService {

    private final PensionerRepository pensionerRepository;

    public PensionerServiceImpl() {
        this.pensionerRepository = new PensionerRepositoryImpl();
    }

    @Override
    public Pensioner findByIdNumber(String idNumber) {
        // Validate the ID number
        if (!InputValidator.isValidIdNumber(idNumber)) {
            throw new IllegalArgumentException("The identification number must be between 3 and 16 digits.");
        }
        return pensionerRepository.findByIdNumber(idNumber);
    }

    @Override
    public List<Pensioner> findByAccountNumber(String accountNumber) {
        // Validate the account number
        if (!InputValidator.isValidIdNumber(accountNumber)) {
            throw new IllegalArgumentException("The account number must be 16 digits long.");
        }
        return pensionerRepository.findByAccountNumber(accountNumber);
    }
    @Override
    public void addAffiliation(String idNumber, String affiliationNumber, String payerNit) {
        // Validate inputs
        if (!InputValidator.isValidIdNumber(idNumber)) {
            throw new IllegalArgumentException("The identification number must be between 3 and 16 digits.");
        }
        if (!InputValidator.isValidAffiliationNumber(affiliationNumber)) {
            throw new IllegalArgumentException("The affiliation number must be 12 digits long.");
        }
        if (!InputValidator.isValidPayerNit(payerNit)) {
            throw new IllegalArgumentException("The payer NIT must be between 3 and 16 digits.");
        }

        Pensioner pensioner = pensionerRepository.findByIdNumber(idNumber);
        if (pensioner != null) {
            pensioner.setNumeroIdPensionado(Long.parseLong(affiliationNumber));
            pensioner.setPayerNit(payerNit);
            pensionerRepository.update(pensioner);
        } else {
            throw new IllegalArgumentException("Pensioner with ID number " + idNumber + " not found.");
        }
    }

    @Override
    public void modifyAffiliation(String idNumber, String newAffiliationNumber) {
        // Validate inputs
        if (!InputValidator.isValidIdNumber(idNumber)) {
            throw new IllegalArgumentException("The identification number must be between 3 and 16 digits.");
        }
        if (!InputValidator.isValidAffiliationNumber(newAffiliationNumber)) {
            throw new IllegalArgumentException("The new affiliation number must be 12 digits long.");
        }

        Pensioner pensioner = pensionerRepository.findByIdNumber(idNumber);
        if (pensioner != null) {
            pensioner.setNumeroIdPensionado(Long.parseLong(newAffiliationNumber));
            pensionerRepository.update(pensioner);
        } else {
            throw new IllegalArgumentException("Pensioner with ID number " + idNumber + " not found.");
        }
    }     
}