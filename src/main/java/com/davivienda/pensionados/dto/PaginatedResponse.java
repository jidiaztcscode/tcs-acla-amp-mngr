package com.davivienda.pensionados.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginatedResponse<T> {

    @JsonProperty("items")
    private List<T> data;

    @JsonProperty("totalRecords")
    private long total;

    @JsonProperty("totalPages")
    private long totalPages;

    @JsonProperty("page")
    private int page;

    @JsonProperty("pageSize")
    private int pageSize;

    public PaginatedResponse() {}

    public PaginatedResponse(List<T> data, long total, long totalPages, int page, int pageSize) {
        this.data = data;
        this.total = total;
        this.totalPages = totalPages;
        this.page = page;
        this.pageSize = pageSize;
    }

    public PaginatedResponse(List<T> data, long total, int page, int pageSize) {
        this.data = data;
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = pageSize > 0 ? (long) Math.ceil((double) total / pageSize) : 0;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
