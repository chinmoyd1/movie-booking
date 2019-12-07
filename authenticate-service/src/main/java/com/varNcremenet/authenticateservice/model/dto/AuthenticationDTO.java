package com.varNcremenet.authenticateservice.model.dto;

import com.varNcremenet.authenticateservice.commons.model.dto.GenericDTO;

import java.io.Serializable;

public class AuthenticationDTO implements Serializable,GenericDTO {

    private static final long serialVersionUID = -6986746375915710855L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Username"+username+", Password"+password;
    }
}
