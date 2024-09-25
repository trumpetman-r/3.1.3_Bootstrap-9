package com.webcrudsecurityboot.controller;

import com.webcrudsecurityboot.model.Role;
import com.webcrudsecurityboot.model.User;
import com.webcrudsecurityboot.service.RoleService;
import com.webcrudsecurityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String allUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.findAllUsers());
        model.addAttribute("roles", roleService.findAllRoles());
        return "index";
    }

    @GetMapping("/{id}")
    public String showUserInformation(@AuthenticationPrincipal User user, @PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(user.getId()));
        model.addAttribute("role", roleService.findRoleById(user.getId()));
        return "show";
    }

    @GetMapping("/add")
    public String addUser(Model model, @ModelAttribute("user") User user, @ModelAttribute("role") Role role) {
        model.addAttribute("roles", roleService.findAllRoles());
        return "new";
    }

    @PostMapping("/add")
    public String postAddUser(@ModelAttribute("user") User user, @RequestParam("rolesSelected") Long[] rolesId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.assignRolesToUser(user, rolesId);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("roles", roleService.findAllRoles());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String changeRole(@ModelAttribute("user") User user, @RequestParam("rolesSelected") Long[] rolesId) {
        userService.assignRolesToUser(user, rolesId);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}