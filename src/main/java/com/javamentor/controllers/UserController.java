package com.javamentor.controllers;

import com.javamentor.model.User;
import com.javamentor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserPage(Model model, Principal principal) {
        User user = (principal != null)
                ? (User) userService.loadUserByUsername(principal.getName())
                : new User();
        model.addAttribute("user", user);
        return "user";
    }

}
