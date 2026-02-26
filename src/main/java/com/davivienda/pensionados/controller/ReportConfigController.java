package com.davivienda.pensionados.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.ReportConfigDto;
import com.davivienda.pensionados.service.ReportConfigService;

@RestController
@RequestMapping("/api/reportes")
public class ReportConfigController {

    private final ReportConfigService reportConfigService;

    public ReportConfigController(ReportConfigService reportConfigService) {
        this.reportConfigService = reportConfigService;
    }

    @GetMapping
    public ResponseEntity<List<ReportConfigDto>> listarReportes() {
        return ResponseEntity.ok(reportConfigService.listarReportes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportConfigDto> obtenerReporte(@PathVariable BigDecimal id) {
        return ResponseEntity.ok(reportConfigService.obtenerReporte(id));
    }

    @PostMapping
    public ResponseEntity<ReportConfigDto> crearReporte(@RequestBody ReportConfigDto reportConfigDto) {
        ReportConfigDto created = reportConfigService.crearReporte(reportConfigDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportConfigDto> actualizarReporte(
            @PathVariable BigDecimal id,
            @RequestBody ReportConfigDto reportConfigDto) {
        ReportConfigDto updated = reportConfigService.actualizarReporte(id, reportConfigDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable BigDecimal id) {
        reportConfigService.eliminarReporte(id);
        return ResponseEntity.noContent().build();
    }
}
