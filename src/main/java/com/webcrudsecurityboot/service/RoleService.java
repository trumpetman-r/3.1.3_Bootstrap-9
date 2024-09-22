package com.webcrudsecurityboot.service;

import com.webcrudsecurityboot.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRoleById(Long id);
    void saveRole(Role role);
    Set<Role> findRolesByIds(Long[] rolesId);
}