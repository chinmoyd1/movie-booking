package com.varNcremenet.authenticateservice.service.auth.impl;

import com.varNcremenet.authenticateservice.commons.security.util.JwtTokenProvider;
import com.varNcremenet.authenticateservice.commons.wrapper.GenericResult;
import com.varNcremenet.authenticateservice.dao.UserDAO;
import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.User;
import com.varNcremenet.authenticateservice.model.dto.AuthenticationDTO;
import com.varNcremenet.authenticateservice.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AuthManagementTest {

    @InjectMocks
    private AuthManagement authManagement;

    @Mock
    private UserDAO userDAO;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void getToken() throws UserException {
        User user = new User();
        user.setId(1L);
        user.setUsername("Santa Caluse");
        user.setPassword("1223");
        Optional<User> optUser = Optional.ofNullable(user);

        AuthenticationDTO data = new AuthenticationDTO();
        data.setUsername("Santa Clause");
        data.setPassword("1223");

        when(userDAO.findByUsername("Santa Clause")).thenReturn(optUser);

        String token =authManagement.getToken(data);
        assertEquals(token,token);
    }

    @Test
    void getCurrentUser() {
    }
}