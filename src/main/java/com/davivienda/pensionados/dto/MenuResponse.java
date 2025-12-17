package com.davivienda.pensionados.dto;

import java.util.List;
import java.util.Map;

public class MenuResponse {
    private String profile;
    private Map<String, List<String>> menu;

    public MenuResponse(String profile, Map<String, List<String>> menu) {
        this.profile = profile;
        this.menu = menu;
    }

    public String getProfile() {
        return profile;
    }

    public Map<String, List<String>> getMenu() {
        return menu;
    }
}