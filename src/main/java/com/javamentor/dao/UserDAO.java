package com.javamentor.dao;

import com.javamentor.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    User findOneById(Long id);

    Optional<User> findUserByUsername(String username);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(User user);

    void delete(Long id);
}
