package com.davivienda.pensionados.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.davivienda.pensionados.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}