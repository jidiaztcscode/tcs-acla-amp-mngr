package com.davivienda.pensionados.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactional_logs")
public class TransactionalLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "product_number")
    private String productNumber;

    @Column(name = "result")
    private String result;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "event_origin")
    private String eventOrigin;

    // Getters and Setters
}