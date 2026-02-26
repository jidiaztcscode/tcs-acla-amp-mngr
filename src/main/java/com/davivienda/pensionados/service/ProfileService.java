package com.davivienda.pensionados.service;


import java.util.List;
import java.util.Optional;

import com.davivienda.pensionados.dto.PaginatedResponse;
import com.davivienda.pensionados.dto.ProfileDTO;
import com.davivienda.pensionados.model.Profile;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Optional<Profile> getProfile(Long id);
    PaginatedResponse<ProfileDTO> getProfilesPaginated(int page, int pageSize);
    Profile createProfile(Profile profile);
    Profile updateProfile(Long id, Profile updated);
    void setActive(Long id, boolean active);
}