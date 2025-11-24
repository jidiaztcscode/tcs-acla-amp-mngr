package com.davivienda.pensionados.model;

import java.util.Arrays;
import java.util.List;

/**
 * Enum que define los roles del sistema y sus permisos asociados
 */
public enum Role {
    ADMIN("GG-Rol_AMP_Prod_Admin", "Administrador", Arrays.asList(
            MenuPermission.AFILIACIONES,
            MenuPermission.REINTEGROS,
            MenuPermission.REPORTES,
            MenuPermission.CONSULTAR_LOGS,
            MenuPermission.PARAMETRIZACION_SISTEMA,
            MenuPermission.ADMINISTRACION_PERFILES)),
    ANALISTA("GG-Rol_AMP_Prod_Analista", "Analista", Arrays.asList(
            MenuPermission.REINTEGROS,
            MenuPermission.REPORTES));

    private final String roleName;
    private final String displayName;
    private final List<MenuPermission> permissions;

    Role(String roleName, String displayName, List<MenuPermission> permissions) {
        this.roleName = roleName;
        this.displayName = displayName;
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<MenuPermission> getPermissions() {
        return permissions;
    }

    /**
     * Busca un rol por su nombre
     */
    public static Role fromRoleName(String roleName) {
        for (Role role : values()) {
            if (role.getRoleName().equals(roleName)) {
                return role;
            }
        }
        return ANALISTA; // Rol por defecto
    }

    /**
     * Verifica si el rol tiene un permiso específico
     */
    public boolean hasPermission(MenuPermission permission) {
        return permissions.contains(permission);
    }
}
