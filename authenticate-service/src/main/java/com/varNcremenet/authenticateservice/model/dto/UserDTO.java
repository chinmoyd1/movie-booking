package com.varNcremenet.authenticateservice.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.varNcremenet.authenticateservice.commons.model.dto.GenericDTO;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable, GenericDTO {
    private Long id;
    private String username;
    private List<String> roles;
    private String token;

    public UserDTO(){
     //Blank
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
