package com.github.osivaM.pp_3_1_4_maven.controllers;

import com.github.osivaM.pp_3_1_4_maven.models.Role;
import com.github.osivaM.pp_3_1_4_maven.models.User;
import com.github.osivaM.pp_3_1_4_maven.services.RoleService;
import com.github.osivaM.pp_3_1_4_maven.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    public String getUsers(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.getAllRoles());

        return "users";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user, @ModelAttribute("roles") Role role) {
        role.getUsers().add(user);
        userService.createUser(user);

        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "redirect:/admin";
    }

}
