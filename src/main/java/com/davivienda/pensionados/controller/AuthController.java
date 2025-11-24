package com.davivienda.pensionados.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.UserDTO;
import com.davivienda.pensionados.service.AuthService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para endpoints de autenticación y roles
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Obtiene la información del usuario actual
     */
    @GetMapping("/user/current")
    public ResponseEntity<UserDTO> getCurrentUser() {
        return ResponseEntity.ok(authService.getCurrentUser());
    }

    /**
     * Establece el rol del usuario (para pruebas)
     */
    @PostMapping("/user/role")
    public ResponseEntity<UserDTO> setUserRole(@RequestBody RoleRequest request) {
        return ResponseEntity.ok(authService.setUserRole(request.getRole()));
    }

    /**
     * Clase interna para recibir el rol en el request
     */
    @lombok.Data
    static class RoleRequest {
        private String role;
    }
}
