package com.varNcrement.bookingservice.commons.wrapper;

import com.varNcrement.bookingservice.commons.model.Metadata;
import com.varNcrement.bookingservice.commons.model.Pagination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class GenericResult {

    private HttpStatus httpStatus;
    private String status;
    private String message;
    private Metadata metadata;
    private Pagination pagination;
    private Object result;

    public ResponseEntity getGenericResult(){
        if(metadata==null) {
            metadata = new Metadata();
            if(metadata.getApiVersion()==null)
                metadata.setApiVersion("v1");
        }
        HashMap<String,Object> body = new LinkedHashMap<>();
        body.put("httpStatus",httpStatus);
        body.put("status",status);
        body.put("message",message);
        body.put("metadata",metadata);
        body.put("paginationsorting",pagination);
        body.put("result",result);

        MultiValueMap<String, String> headers = null;

        return new ResponseEntity( body, headers, httpStatus);
    }



    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    //    {
//        "error": {
//        "code": "FIELDS_VALIDATION_ERROR",
//                "message": "One or more fields raised validation errors."
//        "fields": {
//            "email": "Invalid email address.",
//                    "password": "Password too short."
//        }
//    }

}
