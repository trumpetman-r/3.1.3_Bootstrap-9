package com.webcrudsecurityboot.config;

import com.webcrudsecurityboot.model.Role;
import com.webcrudsecurityboot.model.User;
import com.webcrudsecurityboot.service.RoleService;
import com.webcrudsecurityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataLoader {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataLoader(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void fillDatabase() {
        Role roleAdmin = new Role();
        roleAdmin.setRole("ADMIN");
        roleService.saveRole(roleAdmin);

        Role roleUser = new Role();
        roleUser.setRole("USER");
        roleService.saveRole(roleUser);

        User user1 = new User();
        user1.setName("Max");
        user1.setSurName("Ivanov");
        user1.setEmail("ivanov@mail.ru");
        user1.setAge(40);
        user1.setRoles(Set.of(roleAdmin));
        user1.setPassword("$2a$12$fJy6sBY8yPd.JDbrD/gXzO6dTKHrNIwt0cXO0JOfvB1vz4qLY4pVK");

        userService.saveUser(user1);

        User user2 = new User();
        user2.setName("Sergey");
        user2.setSurName("Petrov");
        user2.setEmail("petrov@mail.ru");
        user2.setAge(25);
        user2.setRoles(Set.of(roleUser));
        user2.setPassword("$2a$12$fJy6sBY8yPd.JDbrD/gXzO6dTKHrNIwt0cXO0JOfvB1vz4qLY4pVK");

        userService.saveUser(user2);

        User user3 = new User();
        user3.setName("Anastasiya");
        user3.setSurName("Egorova");
        user3.setEmail("egorova@mail.ru");
        user3.setAge(27);
        user3.setRoles(Set.of(roleUser));
        user3.setPassword("$2a$12$fJy6sBY8yPd.JDbrD/gXzO6dTKHrNIwt0cXO0JOfvB1vz4qLY4pVK");

        userService.saveUser(user3);
    }
}