package com.davivienda.pensionados.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davivienda.pensionados.dto.VistaColumnaDto;
import com.davivienda.pensionados.dto.VistaDto;
import com.davivienda.pensionados.model.transRepDetvista;
import com.davivienda.pensionados.model.transRepVista;
import com.davivienda.pensionados.repository.TransRepDetvistaRepository;
import com.davivienda.pensionados.repository.TransRepVistaRepository;

@Service
@Transactional(readOnly = true)
public class VistaService {

    private final TransRepVistaRepository vistaRepository;
    private final TransRepDetvistaRepository detvistaRepository;

    public VistaService(TransRepVistaRepository vistaRepository, TransRepDetvistaRepository detvistaRepository) {
        this.vistaRepository = vistaRepository;
        this.detvistaRepository = detvistaRepository;
    }

    public List<VistaDto> listarVistas() {
        return vistaRepository.findAll().stream()
                .map(this::toVistaDto)
                .collect(Collectors.toList());
    }

    public VistaDto obtenerVista(BigDecimal idvista) {
        return vistaRepository.findByIdvista(idvista)
                .map(this::toVistaDto)
                .orElseThrow(() -> new IllegalArgumentException("Vista no encontrada: " + idvista));
    }

    public List<VistaColumnaDto> obtenerColumnas(BigDecimal idvista) {
        return detvistaRepository.findByIdvista(idvista).stream()
                .map(this::toVistaColumnaDto)
                .collect(Collectors.toList());
    }

    private VistaDto toVistaDto(transRepVista entity) {
        return VistaDto.builder()
                .idvista(entity.getIdvista())
                .nomvista(entity.getNomvista())
                .descvista(entity.getDescvista())
                .usuCreaApp(entity.getUsuCreaApp())
                .fecCreacion(entity.getFecCreacion())
                .usuModApp(entity.getUsuModApp())
                .fecModApp(entity.getFecModApp())
                .build();
    }

    private VistaColumnaDto toVistaColumnaDto(transRepDetvista entity) {
        return VistaColumnaDto.builder()
                .idDetvista(entity.getIdDetvista())
                .idvista(entity.getIdvista())
                .nomcolunna(entity.getNomcolunna())
                .tipoDato(entity.getTipoDato())
                .longitud(entity.getLongitud())
                .estado(entity.getEstado())
                .pertenecevista(entity.getPertenecevista())
                .usuCreaApp(entity.getUsuCreaApp())
                .fecCreacion(entity.getFecCreacion())
                .usuModApp(entity.getUsuModApp())
                .fecModApp(entity.getFecModApp())
                .build();
    }
}
