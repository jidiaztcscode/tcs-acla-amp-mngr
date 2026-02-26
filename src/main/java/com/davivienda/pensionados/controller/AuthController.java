package com.davivienda.pensionados.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    /**
     * Endpoint para obtener información del usuario actual
     * Este endpoint es llamado por el frontend al cargar la aplicación
     */
    @GetMapping("/user/current")
    public ResponseEntity<Map<String, Object>> getCurrentUser(Authentication authentication) {
        
        // Verificar si el usuario está autenticado
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        // Construir respuesta con información del usuario
        Map<String, Object> user = new HashMap<>();
        user.put("username", authentication.getName());
        user.put("displayName", authentication.getName());
        
        // Determinar rol basado en las autoridades del usuario
        String role = determineUserRole(authentication);
        user.put("role", role);
        user.put("roleDisplayName", getRoleDisplayName(role));
        user.put("permissions", getPermissionsForRole(role));
        
        return ResponseEntity.ok(user);
    }
    
    /**
     * Endpoint para cambiar el rol del usuario (para pruebas)
     */
    @PostMapping("/user/role")
    public ResponseEntity<Map<String, Object>> setUserRole(
            @RequestBody Map<String, String> request,
            Authentication authentication) {
        
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        // En un entorno real, esto modificaría la sesión o base de datos
        String newRole = request.get("role");
        
        // Devolver usuario actualizado
        Map<String, Object> user = new HashMap<>();
        user.put("username", authentication.getName());
        user.put("displayName", authentication.getName());
        user.put("role", newRole);
        user.put("roleDisplayName", getRoleDisplayName(newRole));
        user.put("permissions", getPermissionsForRole(newRole));
        
        return ResponseEntity.ok(user);
    }
    
    /**
     * Determina el rol del usuario basado en las autoridades de Spring Security
     */
    private String determineUserRole(Authentication authentication) {
        // Extraer roles de las autoridades de Spring Security
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().contains("ADMIN"))) {
            return "ADMIN";
        } else if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().contains("MANAGER"))) {
            return "MANAGER";
        } else {
            return "USER";
        }
    }
    
    /**
     * Obtiene los permisos para un rol específico
     */
    private List<String> getPermissionsForRole(String role) {
        return switch (role) {
            case "ADMIN" -> List.of(
                "VIEW_REPORTS", 
                "CREATE_REPORTS", 
                "EDIT_REPORTS", 
                "DELETE_REPORTS",
                "MANAGE_USERS"
            );
            case "MANAGER" -> List.of(
                "VIEW_REPORTS", 
                "CREATE_REPORTS", 
                "EDIT_REPORTS"
            );
            default -> List.of("VIEW_REPORTS");
        };
    }
    
    /**
     * Obtiene el nombre de visualización del rol
     */
    private String getRoleDisplayName(String role) {
        return switch (role) {
            case "GG-Rol_AMP_Prod_Admin" -> "Administrador";
            case "GG-Rol_AMP_Prod_Analista" -> "Analista";
            case "ADMIN" -> "Administrador";
            case "MANAGER" -> "Gerente";
            default -> "Usuario";
        };
    }
}
