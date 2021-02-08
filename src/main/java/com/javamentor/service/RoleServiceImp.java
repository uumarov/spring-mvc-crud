package com.javamentor.service;

import com.javamentor.dao.RoleDAO;
import com.javamentor.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Transactional
    @Override
    public Role findOneById(Long id) {
        return roleDAO.findOneById(id);
    }

    @Transactional
    @Override
    public Role findOneByRoleName(String roleName) {
        return roleDAO.findOneByRoleName(roleName);
    }

    @Transactional
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Transactional
    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Transactional
    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Transactional
    @Override
    public void delete(Role role) {
        roleDAO.delete(role);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        roleDAO.delete(id);
    }
}
