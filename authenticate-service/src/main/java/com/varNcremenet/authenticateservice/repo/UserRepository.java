package com.varNcremenet.authenticateservice.repo;

import com.varNcremenet.authenticateservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, Long> {

    Optional<User> findById(long id);

    @Override
    Page<User> findAll(Specification specification, Pageable pageable);

    @Query(value = "SELECT * FROM users u WHERE u.user_name = ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Override
    User save(User s);

}
