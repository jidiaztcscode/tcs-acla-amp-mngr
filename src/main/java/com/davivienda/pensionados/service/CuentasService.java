package com.davivienda.pensionados.service;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.davivienda.pensionados.repository.CuentasRepository;
import com.davivienda.pensionados.dto.AperturaCuentaDto;
import com.davivienda.pensionados.dto.CuentaInactivaDto;
import com.davivienda.pensionados.dto.PaginatedResponse;
import com.davivienda.pensionados.domain.CuentasQuery;
import com.davivienda.pensionados.utils.PaginatedResult;

@Service
public class CuentasService {
    private static final int MAX_PAGE_SIZE = 500;

    private final CuentasRepository repository;

    public CuentasService(CuentasRepository repository) {
        this.repository = repository;
    }

    public PaginatedResponse<AperturaCuentaDto> consultarAperturas(CuentasQuery query) {
        CuentasQuery normalized = normalizeQuery(query, "NombrePensionado");
        normalized = normalizeAperturasSort(normalized);
        PaginatedResult<AperturaCuentaDto> result = repository.consultarAperturas(normalized);
        PaginatedResponse<AperturaCuentaDto> response = new PaginatedResponse<>();
        response.setData(result.getItems());
        response.setTotal(result.getTotalRecords());
        response.setTotalPages(result.getTotalPages());
        response.setPage(normalized.getPagina());
        response.setPageSize(normalized.getRegistrosPorPagina());
        return response;
    }

    public PaginatedResponse<CuentaInactivaDto> consultarInactivas(CuentasQuery query) {
        CuentasQuery normalized = normalizeQuery(query, "IdAfiliacion");
        PaginatedResult<CuentaInactivaDto> result = repository.consultarInactivas(normalized);
        PaginatedResponse<CuentaInactivaDto> response = new PaginatedResponse<>();
        response.setData(result.getItems());
        response.setTotal(result.getTotalRecords());
        response.setTotalPages(result.getTotalPages());
        response.setPage(normalized.getPagina());
        response.setPageSize(normalized.getRegistrosPorPagina());
        return response;
    }

    private CuentasQuery normalizeQuery(CuentasQuery query, String defaultSort) {
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

    private CuentasQuery normalizeAperturasSort(CuentasQuery query) {
        String sort = query.getCampoOrdenamiento();
        if ("NumeroIdPensionado".equalsIgnoreCase(sort) || "IdAfiliacion".equalsIgnoreCase(sort)) {
            return query.toBuilder()
                    .campoOrdenamiento("NombrePensionado")
                    .build();
        }
        return query;
    }

    private void validateRange(LocalDate desde, LocalDate hasta) {
        Objects.requireNonNull(desde, "La fecha inicial es obligatoria");
        Objects.requireNonNull(hasta, "La fecha final es obligatoria");
        if (hasta.isBefore(desde)) {
            throw new IllegalArgumentException("La fecha final debe ser mayor o igual a la fecha inicial");
        }
    }
}
