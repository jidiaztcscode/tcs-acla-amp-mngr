package com.davivienda.pensionados.serviceImpl;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davivienda.pensionados.dto.ClientDTO;
import com.davivienda.pensionados.dto.MessageResponseDTO;
import com.davivienda.pensionados.mapper.ClientMapper;
import com.davivienda.pensionados.model.Client;
import com.davivienda.pensionados.repository.ClientRepository;
import com.davivienda.pensionados.service.ClientService;
import com.davivienda.pensionados.utils.Constants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository repository;
	private final ClientMapper mapper;

	@Override
	public Page<ClientDTO> findAll(int pageNumber, int size) {
		log.info(Constants.FETCHING_ALL , Constants.CLIENTS);
		Pageable pageable = PageRequest.of(pageNumber, size);
		Page<ClientDTO> page = repository.findAll(pageable).map(mapper::toDTO);
		log.info(Constants.FOUND, page.getSize(), Constants.CLIENTS);
		return page;
	}

	@Override
	public ClientDTO findById(Long id) {
		ClientDTO dto = new ClientDTO();
		log.info(Constants.FETCHING_BY_ID, Constants.CLIENTS, id);
		Client entity = repository.findById(id).orElseThrow(() -> {
			log.warn(Constants.NOT_FOUND_BY_ID, Constants.CLIENT, id);
			return new NoSuchElementException(Constants.NOT_FOUND_SPA);
		});
		log.info(Constants.FOUND, Constants.CLIENT, entity.getId());
		dto = mapper.toDTO(entity);
		return dto;
	}

	@Override
	public MessageResponseDTO create(ClientDTO dto) {
		log.info(Constants.CREATING_NEW, Constants.CLIENT, dto.getFullName());
		dto.setId(null);
		Client entity = mapper.toEntity(dto);
		Client saved = repository.save(entity);
		
		log.info(Constants.CREATED, Constants.CLIENT, saved.getId());
		return new MessageResponseDTO(Constants.CREATED_SPA);
	}

	@Override
	public MessageResponseDTO update(ClientDTO dto) {
		Long id = dto.getId();
		log.info(Constants.UPDATING, Constants.CLIENT, id);

		Client existing = repository.findById(id).orElseThrow(() -> {
			log.warn(Constants.NOT_FOUND_BY_ID, Constants.CLIENT, id);
			return new NoSuchElementException(Constants.NOT_FOUND_SPA);
		});

		Client updatedEntity = mapper.toEntity(dto);
		updatedEntity.setId(existing.getId());
		Client saved = repository.save(updatedEntity);
		log.info(Constants.UPDATED, Constants.CLIENT, saved.getId());
		return new MessageResponseDTO(Constants.UPDATED_SPA);
	}

	@Override
	public MessageResponseDTO delete(Long id) {
		log.info(Constants.DELETING, Constants.CLIENT, id);
		
		if(!repository.existsById(id)) {
			log.warn(Constants.NOT_FOUND_BY_ID, Constants.CLIENT, id);
			throw new NoSuchElementException(Constants.NOT_FOUND_SPA);
		}
		
		repository.deleteById(id);
		log.info(Constants.DELETING, Constants.CLIENT, id);
		return new MessageResponseDTO(Constants.DELETED_SPA);
	}

}
