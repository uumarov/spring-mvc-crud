package com.javamentor.service.converter;

import com.javamentor.model.Role;
import com.javamentor.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<String, Role> {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role convert(String roleName) {
        return roleService.findOneByRoleName(roleName);
    }
}
