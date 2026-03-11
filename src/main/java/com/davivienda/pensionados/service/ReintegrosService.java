package com.davivienda.pensionados.service;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.davivienda.pensionados.domain.ReintegrosQuery;
import com.davivienda.pensionados.dto.PaginatedResponse;
import com.davivienda.pensionados.dto.ReintegroFallecimientoDto;
import com.davivienda.pensionados.dto.ReintegroRechazadoDto;
import com.davivienda.pensionados.repository.ReintegrosRepository;
import com.davivienda.pensionados.utils.PaginatedResult;

@Service
public class ReintegrosService {
    
    private static final int MAX_PAGE_SIZE = 500;

    private final ReintegrosRepository repository;

    public ReintegrosService(ReintegrosRepository repository) {
        this.repository = repository;
    }

    public PaginatedResponse<ReintegroFallecimientoDto> consultarFallecimientos(ReintegrosQuery query) {
        ReintegrosQuery normalized = normalizeQuery(query, "NOAFILIACIONPAGO");
        PaginatedResult<ReintegroFallecimientoDto> result = repository.consultarFallecimientos(normalized);
        return new PaginatedResponse<>(result.getItems(), result.getTotalRecords(), result.getTotalPages(),
                normalized.getPagina(), normalized.getRegistrosPorPagina());
    }

    public PaginatedResponse<ReintegroRechazadoDto> consultarRechazados(ReintegrosQuery query) {
        ReintegrosQuery normalized = normalizeQuery(query, "NOAFILIACIONPAGO");
        PaginatedResult<ReintegroRechazadoDto> result = repository.consultarRechazados(normalized);
        return new PaginatedResponse<>(result.getItems(), result.getTotalRecords(), result.getTotalPages(),
                normalized.getPagina(), normalized.getRegistrosPorPagina());
    }

    private ReintegrosQuery normalizeQuery(ReintegrosQuery query, String defaultSort) {
        Objects.requireNonNull(query.getFechaInicio(), "La fecha inicial es obligatoria");
        Objects.requireNonNull(query.getFechaFin(), "La fecha final es obligatoria");
        validateRange(query.getFechaInicio(), query.getFechaFin());

        int pagina = query.getPagina() < 1 ? 1 : query.getPagina();
        int registros = query.getRegistrosPorPagina() < 1 ? 20 : Math.min(query.getRegistrosPorPagina(), MAX_PAGE_SIZE);
        String sort = StringUtils.hasText(query.getCampoOrdenamiento()) ? query.getCampoOrdenamiento().trim() : defaultSort;

        return query.toBuilder()
                .pagina(pagina)
                .registrosPorPagina(registros)
                .campoOrdenamiento(sort)
                .build();
    }

    private void validateRange(LocalDate desde, LocalDate hasta) {
        Objects.requireNonNull(desde, "La fecha inicial es obligatoria");
        Objects.requireNonNull(hasta, "La fecha final es obligatoria");
        if (hasta.isBefore(desde)) {
            throw new IllegalArgumentException("La fecha final debe ser mayor o igual a la fecha inicial");
        }
    }
}
