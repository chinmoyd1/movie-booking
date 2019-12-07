package com.varNcremenet.authenticateservice.service.user;

import com.varNcremenet.authenticateservice.commons.exception.ContextInitializationException;
import com.varNcremenet.authenticateservice.commons.context.ContextContainer;
import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;


public interface IUserManagement {

    public ResponseEntity createUser(User user) throws UserException;

    public ResponseEntity modifyCurrentUser(UserDetails userDetails, User data)throws UserException;

    public ResponseEntity getAllUsers(ContextContainer Context)throws ContextInitializationException, UserException;

    public ResponseEntity modifyUser(long id, User data)throws UserException;

    public ResponseEntity getUser(long id)throws UserException;

}
