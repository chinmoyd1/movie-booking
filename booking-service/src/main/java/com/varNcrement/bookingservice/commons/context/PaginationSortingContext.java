package com.varNcrement.bookingservice.commons.context;

public class PaginationSortingContext {
    private String page;
    private String size;
    private String sortOrder;
    private String sortBy;

    public String getPage() {
        return page;
    }

    public Integer getIntPage() {
        if(page != null) {
            return Integer.parseInt(page);
        }
        return 0;
    }
    public Long getLongPage() {
        if(page != null) {
            return Long.parseLong(page);
        }
        return 0l;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public Integer getIntSize() {
        if(size != null) {
            return Integer.parseInt(size);
        }
        return 50;
    }
    public Long getLongSize() {
        if(size != null) {
            return Long.parseLong(size);
        }
        return 50l;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
