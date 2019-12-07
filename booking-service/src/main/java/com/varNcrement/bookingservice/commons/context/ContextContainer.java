package com.varNcrement.bookingservice.commons.context;



public class ContextContainer {

    public static final String CONTEXT_CONTAINER = "ContextContainer";

    private PaginationSortingContext paginationSortingContext;

    private FilterContext filterContext;

    public PaginationSortingContext getPaginationSortingContext() {
        return paginationSortingContext;
    }

    public void setPaginationSortingContext(PaginationSortingContext paginationSortingContext) {
        this.paginationSortingContext = paginationSortingContext;
    }

    public FilterContext getFilterContext() {
        return filterContext;
    }

    public void setFilterContext(FilterContext filterContext) {
        this.filterContext = filterContext;
    }
}
