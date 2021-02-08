package com.javamentor.service;

import com.javamentor.model.Role;

import java.util.List;

public interface RoleService {
    Role findOneById(Long id);

    Role findOneByRoleName(String roleName);

    List<Role> findAll();

    void save(Role role);

    void update(Role role);

    void delete(Role role);

    void delete(Long id);
}
