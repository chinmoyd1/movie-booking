package com.varNcremenet.authenticateservice.service.auth.impl;

import com.varNcremenet.authenticateservice.commons.security.util.JwtTokenProvider;
import com.varNcremenet.authenticateservice.commons.util.DtoUtils;
import com.varNcremenet.authenticateservice.commons.wrapper.GenericResult;
import com.varNcremenet.authenticateservice.dao.UserDAO;
import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.User;
import com.varNcremenet.authenticateservice.model.dto.AuthenticationDTO;
import com.varNcremenet.authenticateservice.model.dto.UserDTO;
import com.varNcremenet.authenticateservice.service.auth.IAuthManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthManagement implements IAuthManagement {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AuthManagement.class);

    @Override
    public String getToken(AuthenticationDTO data) throws UserException {
        logger.debug("Inside Method [getToken]");

        String username = data.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));

        Optional<User> user = this.userDAO.findByUsername(username);

        String token = jwtTokenProvider.createToken(username,user.get().getRoles());

        logger.info("Token Created Successfully for User with id ["+user.get().getId()+"]");

        return token;
    }

    @Override
    public ResponseEntity getCurrentUser(UserDetails userDetails) throws UserException {
        logger.debug("Inside Method [getCurrentUser]");

        Optional<User> user = this.userDAO.findByUsername(userDetails.getUsername());
        logger.info("User fetched Successfully from token for User with id ["+user.get().getId()+"]");

        GenericResult genericResult = new GenericResult();
        genericResult.setStatus("Success");
        genericResult.setHttpStatus(HttpStatus.OK);
        genericResult.setResult(new DtoUtils().convertToDto(user.get(), new UserDTO()));
        return genericResult.getGenericResult();
    }
}
