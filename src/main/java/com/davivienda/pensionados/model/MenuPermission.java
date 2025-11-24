package com.davivienda.pensionados.model;

/**
 * Enum que define los permisos de menú disponibles en el sistema
 */
public enum MenuPermission {
    AFILIACIONES("Afiliaciones"),
    REINTEGROS("Reintegros"),
    REPORTES("Reportes"),
    CONSULTAR_LOGS("Consultar Logs"),
    PARAMETRIZACION_SISTEMA("Parametrizacion Del Sistema"),
    ADMINISTRACION_PERFILES("Administracion De Perfiles");

    private final String displayName;

    MenuPermission(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
