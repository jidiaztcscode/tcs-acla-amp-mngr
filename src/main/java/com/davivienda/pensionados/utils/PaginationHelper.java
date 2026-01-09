package com.davivienda.pensionados.utils;


import java.util.List;

public class PaginationHelper<T> {
    public List<T> paginate(List<T> items, int page, int size) {
        int fromIndex = Math.min(page * size, items.size());
        int toIndex = Math.min(fromIndex + size, items.size());
        return items.subList(fromIndex, toIndex);
    }
}