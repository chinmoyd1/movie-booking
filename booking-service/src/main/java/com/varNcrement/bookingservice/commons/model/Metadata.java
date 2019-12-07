package com.varNcrement.bookingservice.commons.model;

import java.io.Serializable;

public class Metadata implements Serializable {

    private final String module = "authenticate-user";
    private String apiVersion;

    public String getModule() {
        return module;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
