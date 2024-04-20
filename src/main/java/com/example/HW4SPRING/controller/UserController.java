package com.example.HW4SPRING.controller;


import com.example.HW4SPRING.model.User;
import com.example.HW4SPRING.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", UserService.getAllUsers());
        return "users.html";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {
        UserService.addUser(user);
        return getUsers(model);
    }
}