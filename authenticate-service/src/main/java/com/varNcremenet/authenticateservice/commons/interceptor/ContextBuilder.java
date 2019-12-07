package com.varNcremenet.authenticateservice.commons.interceptor;

import com.varNcremenet.authenticateservice.commons.context.ContextContainer;
import com.varNcremenet.authenticateservice.commons.context.FilterContext;
import com.varNcremenet.authenticateservice.commons.context.PaginationSortingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ContextBuilder extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ContextBuilder.class);

    private static final String SIZE = "size";
    private static final String PAGE = "page";
    private static final String FILTER = "filter";
    private static final String SORTORDER = "sortorder";
    private static final String SORTBY = "sortby";

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

        logger.debug("Building Context.");

        PaginationSortingContext paginationSortingContext = new PaginationSortingContext();
        paginationSortingContext.setSize(request.getParameter(SIZE));
        paginationSortingContext.setPage(request.getParameter(PAGE));

        String filter = request.getParameter(FILTER);
        FilterContext filterContext = new FilterContext();
        filterContext.setFilter(filter);

        String sortBy = request.getParameter(SORTBY);
        String sortOrder = request.getParameter(SORTORDER);

        paginationSortingContext.setSortBy(sortBy);
        paginationSortingContext.setSortOrder(sortOrder);

        ContextContainer container = new ContextContainer();
        // populate ContextContainer Class
        container.setFilterContext(filterContext);
        container.setPaginationSortingContext(paginationSortingContext);

        request.setAttribute(ContextContainer.CONTEXT_CONTAINER, container);

        return super.preHandle(request, response, handler);
    }
}
