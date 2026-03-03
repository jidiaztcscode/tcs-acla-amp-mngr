package com.davivienda.pensionados.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Objects;

import com.davivienda.pensionados.domain.MesadasQuery;
import com.davivienda.pensionados.dto.CertificadoMesadaDto;
import com.davivienda.pensionados.dto.MesadaResumenDto;
import com.davivienda.pensionados.dto.PagoMesadaDto;
import com.davivienda.pensionados.dto.RechazoMesadaDto;
import com.davivienda.pensionados.repository.MesadasRepository;
import com.davivienda.pensionados.utils.PaginatedResult;
import com.davivienda.pensionados.dto.PaginatedResponse;

@Service
public class MesadasService {

    private static final int MAX_PAGE_SIZE = 500;

    private final MesadasRepository repository;

    public MesadasService(MesadasRepository repository) {
        this.repository = repository;
    }

    public PaginatedResponse<PagoMesadaDto> consultarPagos(MesadasQuery query) {
        MesadasQuery normalized = normalizeQuery(query, "NumeroIdPensionado");
        PaginatedResult<PagoMesadaDto> result = repository.consultarPagos(normalized);
        PaginatedResponse<PagoMesadaDto> response = new PaginatedResponse<>();
        response.setData(result.getItems());
        response.setTotal(result.getTotalRecords());
        response.setTotalPages(result.getTotalPages());
        response.setPage(normalized.getPagina());
        response.setPageSize(normalized.getRegistrosPorPagina());
        return response;
    }

    public PaginatedResponse<RechazoMesadaDto> consultarRechazos(MesadasQuery query) {
        MesadasQuery normalized = normalizeQuery(query, "NumeroIdPensionado");
        PaginatedResult<RechazoMesadaDto> result = repository.consultarRechazos(normalized);
        PaginatedResponse<RechazoMesadaDto> response = new PaginatedResponse<>();
        response.setData(result.getItems());
        response.setTotal(result.getTotalRecords());
        response.setTotalPages(result.getTotalPages());
        response.setPage(normalized.getPagina());
        response.setPageSize(normalized.getRegistrosPorPagina());
        return response;
    }

    public List<CertificadoMesadaDto> consultarCertificados(LocalDate fechaInicio, LocalDate fechaFin, int pagina, int registros) {
        validateRange(fechaInicio, fechaFin);
        return repository.consultarCertificados(fechaInicio, fechaFin);
    }

    private MesadasQuery normalizeQuery(MesadasQuery query, String defaultSort) {
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
