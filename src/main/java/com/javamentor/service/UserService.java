package com.javamentor.service;

import com.javamentor.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User findOneById(Long id);

    Optional<User> findUserByUsername(String username);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(User user);

    void delete(Long id);
}
