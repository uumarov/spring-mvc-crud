package com.javamentor.service;

import com.javamentor.model.User;

import java.util.List;

public interface UserService {
    User findOneById(Long id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
    void delete(Long id);
}
