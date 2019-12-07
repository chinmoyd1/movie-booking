package com.varNcremenet.authenticateservice.commons.model;

public class Pagination {
     private Long page;
     private Long size;
     private Long totalelements;
     private Integer totalpages;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotalelements() {
        return totalelements;
    }

    public void setTotalelements(Long totalelements) {
        this.totalelements = totalelements;
    }

    public Integer getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(Integer totalpages) {
        this.totalpages = totalpages;
    }
}
