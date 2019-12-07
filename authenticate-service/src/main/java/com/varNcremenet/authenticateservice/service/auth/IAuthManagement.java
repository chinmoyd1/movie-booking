package com.varNcremenet.authenticateservice.service.auth;

import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.dto.AuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthManagement {

    public String getToken(AuthenticationDTO data)throws UserException;

    public ResponseEntity getCurrentUser(UserDetails userDetails)throws UserException;

}
