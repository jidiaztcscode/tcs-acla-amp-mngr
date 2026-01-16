package com.davivienda.pensionados.utils;


import java.time.LocalDate;

public class DateValidator {

    public static boolean isStartDateBeforeEndDate(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(endDate) || startDate.isEqual(endDate);
    }
}