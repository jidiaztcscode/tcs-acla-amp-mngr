package com.davivienda.pensionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
