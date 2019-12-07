package com.varNcremenet.authenticateservice.commons.service.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class FilterService<T>{

    private List<SearchCriteria> params;

    public FilterService() {
    }

    private void with(String key, String operation, String value) {
        params.add(new SearchCriteria(key, operation, value));
    }

    private Specification<T> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream().map(GenericSpecification::new).collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }

    public Specification getProcessedFilter(String filter) {
        params = new ArrayList<>();
        if(filter!=null) {
            filter.replaceAll("::", " ");
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(filter + ",");

            while (matcher.find()) {
                with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }

        Specification<T> spec = build();

        return spec;
    }
}
