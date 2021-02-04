package com.javamentor.controllers;

import com.javamentor.model.User;
import com.javamentor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String index(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/edit/{id}")
    public String userEditForm(Model model, @PathVariable(name = "id") Long id) {
        User user = userService.findOneById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @GetMapping(value = "/add")
    public String userAddForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping(value = "/add")
    public String userCreate(@ModelAttribute(name = "user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/edit")
    public String userSave(@ModelAttribute(name = "user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String userAddForm(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
