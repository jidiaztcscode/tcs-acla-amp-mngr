package com.davivienda.pensionados.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "security_logs")
public class SecurityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "event_origin")
    private String eventOrigin;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    // Getters and Setters
}