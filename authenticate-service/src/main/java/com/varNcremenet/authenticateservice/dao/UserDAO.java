package com.varNcremenet.authenticateservice.dao;

import com.varNcremenet.authenticateservice.model.User;
import com.varNcremenet.authenticateservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Repository
public class UserDAO{

    @Autowired
    UserRepository userRepository;

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Page<User> findAll(Specification specification, Pageable pageable) {
        return userRepository.findAll(specification,pageable);
    }
}
