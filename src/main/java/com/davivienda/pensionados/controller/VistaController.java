package com.davivienda.pensionados.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.VistaColumnaDto;
import com.davivienda.pensionados.dto.VistaDto;
import com.davivienda.pensionados.service.VistaService;

@RestController
@RequestMapping("/api/vistas")
public class VistaController {

    private final VistaService vistaService;

    public VistaController(VistaService vistaService) {
        this.vistaService = vistaService;
    }

    @GetMapping
    public ResponseEntity<List<VistaDto>> listarVistas() {
        return ResponseEntity.ok(vistaService.listarVistas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VistaDto> obtenerVista(@PathVariable BigDecimal id) {
        return ResponseEntity.ok(vistaService.obtenerVista(id));
    }

    @GetMapping("/{id}/columnas")
    public ResponseEntity<List<VistaColumnaDto>> obtenerColumnas(@PathVariable BigDecimal id) {
        return ResponseEntity.ok(vistaService.obtenerColumnas(id));
    }
}
