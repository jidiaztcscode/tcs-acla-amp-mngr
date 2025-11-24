package com.davivienda.pensionados.serviceImpl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davivienda.pensionados.dto.UserDTO;
import com.davivienda.pensionados.model.MenuPermission;
import com.davivienda.pensionados.model.Role;
import com.davivienda.pensionados.service.AuthService;

/**
 * Implementación del servicio de autenticación
 * Nota: Esta es una implementación simplificada para pruebas.
 * En producción, debería integrarse con el sistema de autenticación real
 * (OAuth2/JWT)
 */
@Service
public class AuthServiceImpl implements AuthService {

    // Simulación de usuario en sesión (en producción vendría del contexto de
    // seguridad)
    private Role currentUserRole = Role.ADMIN;
    private String currentUsername = "Juanito Pérez";

    @Override
    public UserDTO getCurrentUser() {
        return buildUserDTO(currentUserRole);
    }

    @Override
    public UserDTO setUserRole(String roleName) {
        // Buscar el rol por nombre
        this.currentUserRole = Role.fromRoleName(roleName);
        return buildUserDTO(currentUserRole);
    }

    @Override
    public boolean hasPermission(String permission) {
        try {
            MenuPermission menuPermission = MenuPermission.valueOf(permission);
            return currentUserRole.hasPermission(menuPermission);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Construye el DTO de usuario a partir del rol
     */
    private UserDTO buildUserDTO(Role role) {
        return UserDTO.builder()
                .username(currentUsername)
                .displayName(currentUsername)
                .role(role.getRoleName())
                .roleDisplayName(role.getDisplayName())
                .permissions(role.getPermissions().stream()
                        .map(MenuPermission::getDisplayName)
                        .collect(Collectors.toList()))
                .build();
    }
}
