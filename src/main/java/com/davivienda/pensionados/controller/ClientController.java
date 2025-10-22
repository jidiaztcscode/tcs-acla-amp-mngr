package com.davivienda.pensionados.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.ClientDTO;
import com.davivienda.pensionados.dto.MessageResponseDTO;
import com.davivienda.pensionados.service.ClientService;
import com.davivienda.pensionados.validation.ConsultParametersFirstGroupValidation;
import com.davivienda.pensionados.validation.ConsultParametersSecondGroupValidation;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
	
	private final ClientService service;
	
	@PostMapping
	public ResponseEntity<MessageResponseDTO> create(@Validated(ConsultParametersSecondGroupValidation.class) @RequestBody ClientDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return ResponseEntity.ok(service.findAll(page, size));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping
	public ResponseEntity<MessageResponseDTO> update(@Validated(ConsultParametersFirstGroupValidation.class) @RequestBody ClientDTO dto ) {
		return ResponseEntity.ok(service.update(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponseDTO> delete(@PathVariable Long id) {
		return ResponseEntity.ok(service.delete(id));
	}
	

}
