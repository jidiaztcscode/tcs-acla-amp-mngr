package com.davivienda.pensionados.controller;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.davivienda.pensionados.dto.MenuResponse;
import com.davivienda.pensionados.model.Menu;
import com.davivienda.pensionados.model.Profile;
import com.davivienda.pensionados.repository.ProfileRepository;
//GG Role AMP_Des_Admin
//GG Role AMP_Des_Analista
//GG Role AMP_Des_Reintegros
//GG Role AMP_Des_Autorizacion
//GG Role AMP_Des_GestionPerfiles
@RestController
public class MenuController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/api/menu")
    public MenuResponse getMenu(Authentication authentication) {
        // PRUEBA RÁPIDA: Forzar el rol deseado aquí
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_AMP_Prod_Analista"); // Cambia aquí el rol para probar otros perfiles

        // Buscar el primer perfil que coincida con los roles del usuario
        for (String role : roles) {
            if (role.startsWith("ROLE_")) {
                String profileName = role.substring(5); // Quita el prefijo ROLE_
                Optional<Profile> profileOpt = profileRepository.findByName(profileName);
                if (profileOpt.isPresent()) {
                    Profile profile = profileOpt.get();
                    // Construir el menú agrupando por menú padre
                    Map<String, List<String>> menu = profile.getMenus().stream()
                        .filter(m -> m.getParent() == null)
                        .collect(Collectors.toMap(
                            Menu::getName,
                            parent -> profile.getMenus().stream()
                                .filter(m -> parent.equals(m.getParent()))
                                .map(Menu::getName)
                                .collect(Collectors.toList())
                        ));
                    return new MenuResponse(profileName, menu);
                }
            }
        }
        // Si no hay perfil asignado
        return new MenuResponse("No Profile", Collections.emptyMap());
    }
}