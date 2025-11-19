package com.davivienda.pensionados.service;

import org.springframework.data.domain.Page;

import com.davivienda.pensionados.dto.ClientDTO;
import com.davivienda.pensionados.dto.MessageResponseDTO;

public interface ClientService {

	Page<ClientDTO> findAll(int pageNumber, int size);
	ClientDTO findById(Long id);
	MessageResponseDTO create(ClientDTO dto);
	MessageResponseDTO update(ClientDTO dto);
	MessageResponseDTO delete(Long id);
}
