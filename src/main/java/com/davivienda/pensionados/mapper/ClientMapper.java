package com.davivienda.pensionados.mapper;

import org.mapstruct.Mapper;

import com.davivienda.pensionados.dto.ClientDTO;
import com.davivienda.pensionados.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	
	Client toEntity(ClientDTO dto);
	
	ClientDTO toDTO(Client entity);

}
