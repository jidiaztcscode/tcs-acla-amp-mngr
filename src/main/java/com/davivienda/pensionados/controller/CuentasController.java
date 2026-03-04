package com.davivienda.pensionados.controller;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.domain.CuentasQuery;
import com.davivienda.pensionados.service.CuentasService;
import com.davivienda.pensionados.dto.AperturaCuentaDto;
import com.davivienda.pensionados.dto.CuentaInactivaDto;
import com.davivienda.pensionados.dto.PaginatedResponse;

@RestController
@RequestMapping("/api/cuentas")
@Validated
public class CuentasController {
        private final CuentasService cuentasService;

    public CuentasController(CuentasService cuentasService) {
        this.cuentasService = cuentasService;
    }

    @GetMapping("/aperturas")
    public ResponseEntity<PaginatedResponse<AperturaCuentaDto>> consultarAperturas(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "empresa", required = false) Long empresa,
            @RequestParam(value = "documento", required = false) Long documento,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "cuentaPensionado", required = false) Long cuentaPensionado,
            @RequestParam(value = "cuentaEmpleador", required = false) Long cuentaEmpleador,
            @RequestParam(value = "cuentaPagadora", required = false) Long cuentaPagadora,
            @RequestParam(value = "afiliacion", required = false) Long afiliacion,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        CuentasQuery query = CuentasQuery.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .numeroIdEmpresa(empresa)
                .numeroIdPensionado(documento)
                .tipoIdentificacion(tipoDocumento)
                .numeroCuentaPensionado(cuentaPensionado)
                .cuentaEmpleador(cuentaEmpleador)
                .numeroCuentaPagadora(cuentaPagadora)
                .idAfiliacion(afiliacion)
                .ascending(!"desc".equalsIgnoreCase(direction))
                .campoOrdenamiento(sort)
                .pagina(pagina)
                .registrosPorPagina(registros)
                .build();

        return ResponseEntity.ok(cuentasService.consultarAperturas(query));
    }

    @GetMapping("/inactivas")
    public ResponseEntity<PaginatedResponse<CuentaInactivaDto>> consultarInactivas(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "empresa", required = false) Long empresa,
            @RequestParam(value = "documento", required = false) Long documento,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "cuentaPensionado", required = false) Long cuentaPensionado,
            @RequestParam(value = "cuentaPagadora", required = false) Long cuentaPagadora,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        CuentasQuery query = CuentasQuery.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .numeroIdEmpresa(empresa)
                .numeroIdPensionado(documento)
                .tipoIdentificacion(tipoDocumento)
                .numeroCuentaPensionado(cuentaPensionado)
                .numeroCuentaPagadora(cuentaPagadora)
                .ascending(!"desc".equalsIgnoreCase(direction))
                .campoOrdenamiento(sort)
                .pagina(pagina)
                .registrosPorPagina(registros)
                .build();

        return ResponseEntity.ok(cuentasService.consultarInactivas(query));
    }
    
}
