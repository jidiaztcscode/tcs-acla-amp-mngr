package com.davivienda.pensionados.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.domain.ReintegrosQuery;
import com.davivienda.pensionados.dto.PaginatedResponse;
import com.davivienda.pensionados.dto.ReintegroFallecimientoDto;
import com.davivienda.pensionados.dto.ReintegroRechazadoDto;
import com.davivienda.pensionados.service.ReintegrosService;

@RestController
@RequestMapping("/api/reintegros")
@Validated
public class ReintegrosController {
    
    private final ReintegrosService reintegrosService;

    public ReintegrosController(ReintegrosService reintegrosService) {
        this.reintegrosService = reintegrosService;
    }

    @GetMapping("/fallecimientos")
    public ResponseEntity<PaginatedResponse<ReintegroFallecimientoDto>> consultarFallecimientos(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "empresa", required = false) Long empresa,
            @RequestParam(value = "documento", required = false) Long documento,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "cuentaPensionado", required = false) Long cuentaPensionado,
            @RequestParam(value = "cuentaPagadora", required = false) Long cuentaPagadora,
            @RequestParam(value = "afiliacion", required = false) Long afiliacion,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        ReintegrosQuery query = ReintegrosQuery.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .numeroIdEmpresa(empresa)
                .numeroIdPensionado(documento)
                .tipoIdentificacion(tipoDocumento)
                .numeroCuentaPensionado(cuentaPensionado)
                .numeroCuentaPagadora(cuentaPagadora)
                .idAfiliacion(afiliacion)
                .ascending(!"desc".equalsIgnoreCase(direction))
                .campoOrdenamiento(sort)
                .pagina(pagina)
                .registrosPorPagina(registros)
                .build();

        return ResponseEntity.ok(reintegrosService.consultarFallecimientos(query));
    }

    @GetMapping("/rechazados")
    public ResponseEntity<PaginatedResponse<ReintegroRechazadoDto>> consultarRechazados(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "empresa", required = false) Long empresa,
            @RequestParam(value = "documento", required = false) Long documento,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "cuentaPensionado", required = false) Long cuentaPensionado,
            @RequestParam(value = "cuentaPagadora", required = false) Long cuentaPagadora,
            @RequestParam(value = "afiliacion", required = false) Long afiliacion,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        ReintegrosQuery query = ReintegrosQuery.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .numeroIdEmpresa(empresa)
                .numeroIdPensionado(documento)
                .tipoIdentificacion(tipoDocumento)
                .numeroCuentaPensionado(cuentaPensionado)
                .numeroCuentaPagadora(cuentaPagadora)
                .idAfiliacion(afiliacion)
                .ascending(!"desc".equalsIgnoreCase(direction))
                .campoOrdenamiento(sort)
                .pagina(pagina)
                .registrosPorPagina(registros)
                .build();

        return ResponseEntity.ok(reintegrosService.consultarRechazados(query));
    }
}
