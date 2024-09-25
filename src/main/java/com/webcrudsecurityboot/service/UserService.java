package com.webcrudsecurityboot.service;

import com.webcrudsecurityboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    void saveUser(User user);
    void updateUser(User updatedUser);
    void deleteUserById(Long id);
    UserDetails loadUserByUsername(String email);
    User findCurrentUser(User user);
    void assignRolesToUser(User user, Long[] rolesId);
}