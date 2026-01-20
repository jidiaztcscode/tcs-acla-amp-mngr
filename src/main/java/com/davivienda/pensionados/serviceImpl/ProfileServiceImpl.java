package com.davivienda.pensionados.serviceImpl;


import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davivienda.pensionados.model.Menu;
import com.davivienda.pensionados.model.Profile;
import com.davivienda.pensionados.repository.MenuRepository;
import com.davivienda.pensionados.repository.ProfileRepository;
import com.davivienda.pensionados.service.ProfileService;
import com.davivienda.pensionados.utils.SecurityLogs;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> getProfile(Long id) {
        return profileRepository.findById(id);
    }

@Override
public Profile createProfile(Profile profile) {
    // ...existing validation code...

    // Fetch menus from DB by IDs
    Set<Menu> attachedMenus = new HashSet<>();
    if (profile.getMenus() != null) {
        for (Menu menu : profile.getMenus()) {
            Menu attachedMenu = menuRepository.findById(menu.getId())
                .orElseThrow(() -> new IllegalArgumentException("Menu with id " + menu.getId() + " not found"));
            attachedMenus.add(attachedMenu);
        }
    }
    profile.setMenus(attachedMenus);

    SecurityLogs.log("Profile created: " + profile.getName());
    return profileRepository.save(profile);
}

@Override
@Transactional
public Profile updateProfile(Long id, Profile updated) {
    Profile profile = profileRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Profile not found"));
    if (!profile.getName().equals(updated.getName())) {
        throw new IllegalArgumentException("Profile name cannot be changed");
    }
    if (updated.getDescription().length() < 20 || updated.getDescription().length() > 250) {
        throw new IllegalArgumentException("The description field must be between 20 and 250 characters long");
    }

    // Fetch menus from DB by IDs
    Set<Menu> attachedMenus = new HashSet<>();
    if (updated.getMenus() != null) {
        for (Menu menu : updated.getMenus()) {
            Menu attachedMenu = menuRepository.findById(menu.getId())
                .orElseThrow(() -> new IllegalArgumentException("Menu with id " + menu.getId() + " not found"));
            attachedMenus.add(attachedMenu);
        }
    }
    profile.setDescription(updated.getDescription());
    profile.setMenus(attachedMenus);

    SecurityLogs.log("Profile updated: " + profile.getName());
    return profileRepository.save(profile);
}

    @Override
    public void setActive(Long id, boolean active) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Profile not found"));
        profile.setActive(active);
        profileRepository.save(profile);
        SecurityLogs.log("Profile " + (active ? "activated" : "deactivated") + ": " + profile.getName());
    }




}