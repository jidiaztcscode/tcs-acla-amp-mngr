package com.davivienda.pensionados.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.davivienda.pensionados.model.Pensioner;
import com.davivienda.pensionados.service.PensionerService;
import com.davivienda.pensionados.utils.InputValidator;

@RestController
@RequestMapping("/api/pensioners")
public class PensionerController {

	private final PensionerService pensionerService;

	@Autowired
	public PensionerController(PensionerService pensionerService) {
		 this.pensionerService = pensionerService;
	}

	   @GetMapping("/by-id")
	   public ResponseEntity<?> getPensionerById(@RequestParam String idNumber) {
		   if (!InputValidator.isValidIdNumber(idNumber)) {
			   return ResponseEntity.badRequest().body("The identification number must be between 3 and 16 digits.");
		   }
		   Pensioner pensioner = pensionerService.findByIdNumber(idNumber);
		   if (pensioner == null) {
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Identification number not registered as a pensioner.");
		   }
		   return ResponseEntity.ok(pensioner);
	   }

	   @GetMapping("/by-account")
	   public ResponseEntity<?> getPensionersByAccount(@RequestParam String accountNumber) {
		   if (!InputValidator.isValidIdNumber(accountNumber)) {
			   return ResponseEntity.badRequest().body("The account number must be 16 digits long.");
		   }
		   List<Pensioner> pensioners = pensionerService.findByAccountNumber(accountNumber);
		   if (pensioners.isEmpty()) {
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No affiliation numbers were found for this account or pensioner.");
		   }
		   return ResponseEntity.ok(pensioners);
	   }

	   @PostMapping("/add-affiliation")
	   public ResponseEntity<?> addAffiliation(@RequestParam String idNumber,
											   @RequestParam String affiliationNumber,
											   @RequestParam String payerNit) {
		   if (!InputValidator.isValidIdNumber(idNumber)) {
			   return ResponseEntity.badRequest().body("The identification number must be between 3 and 16 digits.");
		   }
		   if (!InputValidator.isValidAffiliationNumber(affiliationNumber)) {
			   return ResponseEntity.badRequest().body("The affiliation number field must be 12 digits long, if required complete with leading zeros.");
		   }
		   if (!InputValidator.isValidPayerNit(payerNit)) {
			   return ResponseEntity.badRequest().body("The payer NIT must be between 3 and 16 digits.");
		   }
		   pensionerService.addAffiliation(idNumber, affiliationNumber, payerNit);
		   return ResponseEntity.ok("Affiliation added successfully.");
	   }

	   @PutMapping("/modify-affiliation")
	   public ResponseEntity<?> modifyAffiliation(@RequestParam String idNumber,
												  @RequestParam String newAffiliationNumber) {
		   if (!InputValidator.isValidIdNumber(idNumber)) {
			   return ResponseEntity.badRequest().body("The identification number must be between 3 and 16 digits.");
		   }
		   if (!InputValidator.isValidAffiliationNumber(newAffiliationNumber)) {
			   return ResponseEntity.badRequest().body("The new affiliation number must be 12 digits long.");
		   }
		   Pensioner pensioner = pensionerService.findByIdNumber(idNumber);
		   if (pensioner == null) {
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pensioner with the given ID number not found.");
		   }
		   pensionerService.modifyAffiliation(idNumber, newAffiliationNumber);
		   return ResponseEntity.ok("Affiliation modified successfully.");
	   }
}