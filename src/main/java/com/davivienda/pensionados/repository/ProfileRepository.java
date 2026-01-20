package com.davivienda.pensionados.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davivienda.pensionados.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByName(String name);
}