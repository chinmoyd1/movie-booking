package com.varNcrement.bookingservice.commons.service.paginationsorting;

import com.varNcrement.bookingservice.commons.context.PaginationSortingContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PaginationSortingService {

    public Pageable getPageableFilter(PaginationSortingContext paginationSortingContext){

        Sort sort = null;

        if(paginationSortingContext.getSortBy()==null){
            sort = Sort.unsorted();
        }else{
            if(paginationSortingContext.getSortOrder() != null && paginationSortingContext.getSortOrder().equals("dsc")){
                sort = Sort.by(paginationSortingContext.getSortBy()).descending();
            }else{
                sort = Sort.by(paginationSortingContext.getSortBy()).ascending();
            }
        }

        Pageable pageable = PageRequest.of(paginationSortingContext.getIntPage(), paginationSortingContext.getIntSize(),sort);

        return pageable;
    }
}
