package com.davivienda.pensionados.controller;

import java.time.LocalDate;
import java.util.List;

import com.davivienda.pensionados.model.Pensioner;
import com.davivienda.pensionados.service.PensionerService;
import com.davivienda.pensionados.serviceImpl.PensionerServiceImpl;
import com.davivienda.pensionados.utils.InputValidator;

public class PensionerController {
	private final PensionerService pensionerService;

	public PensionerController() {
		this.pensionerService = new PensionerServiceImpl();
	}

	public String getPensionerById(String idNumber) {
		// Validate the ID number before proceeding
		if (!InputValidator.isValidIdNumber(idNumber)) {
			return "The identification number must be between 3 and 16 digits.";
		}

		Pensioner pensioner = pensionerService.findByIdNumber(idNumber);
		if (pensioner == null) {
			return "Identification number not registered as a pensioner.";
		}

		return pensioner.toString();
	}

	public String getPensionersByAccount(String accountNumber) {
		// Validate the account number before proceeding
		if (!InputValidator.isValidIdNumber(accountNumber)) {
			return "The account number must be 16 digits long.";
		}

		List<Pensioner> pensioners = pensionerService.findByAccountNumber(accountNumber);
		if (pensioners.isEmpty()) {
			return "No affiliation numbers were found for this account or pensioner.";
		}

		return pensioners.toString();
	}

	public String addAffiliation(String idNumber, String affiliationNumber, String payerNit) {
		// Validate inputs
        if (!InputValidator.isValidIdNumber(idNumber)) {
            return "The identification number must be between 3 and 16 digits.";
        }
        if (!InputValidator.isValidAffiliationNumber(affiliationNumber)) {
            // Display notice for invalid affiliation number length
            return "The affiliation number field must be 12 digits long, if required complete with leading zeros.";
        }
        if (!InputValidator.isValidPayerNit(payerNit)) {
            return "The payer NIT must be between 3 and 16 digits.";
        }

        // Show confirmation notice
        System.out.println("The affiliation number " + affiliationNumber + " will be added for the account " + idNumber +
                ", associated with the company: " + payerNit + ". Press Accept to proceed or Cancel to abort.");

		// Call the service to add the affiliation
		pensionerService.addAffiliation(idNumber, affiliationNumber, payerNit);
		return "Affiliation added successfully.";
	}

	public String modifyAffiliation(String idNumber, String newAffiliationNumber) {
		// Validate inputs
		if (!InputValidator.isValidIdNumber(idNumber)) {
			return "The identification number must be between 3 and 16 digits.";
		}
		if (!InputValidator.isValidAffiliationNumber(newAffiliationNumber)) {
			return "The new affiliation number must be 12 digits long.";
		}
		
		// Fetch the pensioner to get modification history
        Pensioner pensioner = pensionerService.findByIdNumber(idNumber);
        if (pensioner == null) {
            return "Pensioner with the given ID number not found.";
        }
        
        // Simulate modification history (this would come from the database in a real application)
        int modificationCount = 3; // Example: Assume the affiliation number has been modified 3 times
        LocalDate lastModifiedDate = LocalDate.of(2025, 12, 15); // Example: Last modification date

        // Show confirmation notice
        System.out.println("Previously the affiliation number has been modified " + modificationCount + " time(s), the last update was made on " + lastModifiedDate + ".");
        System.out.println("If you continue, the " + pensioner.getAffiliationNumber() + " affiliation number will be replaced by the " + newAffiliationNumber + " number. Press OK to proceed or Cancel to abort.");

		// Call the service to modify the affiliation
		pensionerService.modifyAffiliation(idNumber, newAffiliationNumber);
		return "Affiliation modified successfully.";
	}
}