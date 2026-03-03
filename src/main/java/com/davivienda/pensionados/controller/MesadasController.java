package com.davivienda.pensionados.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.domain.MesadasQuery;
import com.davivienda.pensionados.dto.CertificadoMesadaDto;
import com.davivienda.pensionados.dto.PagoMesadaDto;
import com.davivienda.pensionados.dto.RechazoMesadaDto;
import com.davivienda.pensionados.service.MesadasService;
import com.davivienda.pensionados.dto.PaginatedResponse;

@RestController
@RequestMapping("/api/mesadas")
@Validated
public class MesadasController {

    private final MesadasService mesadasService;

    public MesadasController(MesadasService mesadasService) {
        this.mesadasService = mesadasService;
    }

    @GetMapping("/pagos")
    public ResponseEntity<PaginatedResponse<PagoMesadaDto>> consultarPagos(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "empresa", required = false) Long empresa,
            @RequestParam(value = "afiliacion", required = false) Long afiliacion,
            @RequestParam(value = "cuentaPensionado", required = false) Long cuentaPensionado,
            @RequestParam(value = "documento", required = false) Long documento,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "cuentaPagadora", required = false) Long cuentaPagadora,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        MesadasQuery query = MesadasQuery.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .numeroIdEmpresa(empresa)
                .numeroAfiliacion(afiliacion)
                .numeroCuentaPensionado(cuentaPensionado)
                .numeroIdPensionado(documento)
                .tipoIdentificacion(tipoDocumento)
                .numeroCuentaPagadora(cuentaPagadora)
                .ascending(!"desc".equalsIgnoreCase(direction))
                .campoOrdenamiento(sort)
                .pagina(pagina)
                .registrosPorPagina(registros)
                .build();

        return ResponseEntity.ok(mesadasService.consultarPagos(query));
    }

    @GetMapping("/rechazos")
    public ResponseEntity<PaginatedResponse<RechazoMesadaDto>> consultarRechazos(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "empresa", required = false) Long empresa,
            @RequestParam(value = "afiliacion", required = false) Long afiliacion,
            @RequestParam(value = "cuentaPensionado", required = false) Long cuentaPensionado,
            @RequestParam(value = "documento", required = false) Long documento,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "cuentaPagadora", required = false) Long cuentaPagadora,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        MesadasQuery query = MesadasQuery.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .numeroIdEmpresa(empresa)
                .numeroAfiliacion(afiliacion)
                .numeroCuentaPensionado(cuentaPensionado)
                .numeroIdPensionado(documento)
                .tipoIdentificacion(tipoDocumento)
                .numeroCuentaPagadora(cuentaPagadora)
                .ascending(!"desc".equalsIgnoreCase(direction))
                .campoOrdenamiento(sort)
                .pagina(pagina)
                .registrosPorPagina(registros)
                .build();

        return ResponseEntity.ok(mesadasService.consultarRechazos(query));
    }

    @GetMapping("/certificados")
    public ResponseEntity<List<CertificadoMesadaDto>> consultarCertificados(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "page", defaultValue = "1") int pagina,
            @RequestParam(value = "size", defaultValue = "20") int registros) {
        return ResponseEntity.ok(mesadasService.consultarCertificados(fechaInicio, fechaFin, pagina, registros));
    }
    
}
