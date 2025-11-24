package com.davivienda.pensionados.service;

import com.davivienda.pensionados.dto.UserDTO;

/**
 * Servicio para gestionar autenticación y permisos
 */
public interface AuthService {

    /**
     * Obtiene la información del usuario actual
     */
    UserDTO getCurrentUser();

    /**
     * Establece el rol del usuario (simulación para pruebas)
     */
    UserDTO setUserRole(String roleName);

    /**
     * Verifica si el usuario tiene un permiso específico
     */
    boolean hasPermission(String permission);
}
