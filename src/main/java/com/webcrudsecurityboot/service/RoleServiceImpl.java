package com.webcrudsecurityboot.service;

import com.webcrudsecurityboot.model.Role;
import com.webcrudsecurityboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Set<Role> findRolesByIds(Long[] rolesId) {
        Set<Role> roles = new HashSet<>();
        for (Long roleId : rolesId) {
            roles.add(findRoleById(roleId));
        }
        return roles;
    }
}