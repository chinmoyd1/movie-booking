package com.varNcremenet.authenticateservice.commons.util;

import com.varNcremenet.authenticateservice.commons.model.dto.GenericDTO;
import org.modelmapper.ModelMapper;

public class DtoUtils {

    public GenericDTO convertToDto(Object obj, GenericDTO mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, GenericDTO mapper) {
        return new ModelMapper().map(mapper, obj.getClass());
    }

}
