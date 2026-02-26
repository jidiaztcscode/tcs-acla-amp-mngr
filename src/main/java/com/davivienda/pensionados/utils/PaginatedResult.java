package com.davivienda.pensionados.utils;

import java.util.List;
import lombok.Value;

@Value
public class PaginatedResult<T> {
    List<T> items;
    long totalRecords;
    long totalPages;
}
