package com.varNcremenet.authenticateservice.commons.security.service;

import com.varNcremenet.authenticateservice.model.User;
import com.varNcremenet.authenticateservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUserDetail implements UserDetailsService {

    @Autowired
    private UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user = users.findByUsername(username);

        if(user.isPresent())
                    return user.get();
        else
            throw new UsernameNotFoundException("User with User Name ["+username+"] not found.");
    }
}
