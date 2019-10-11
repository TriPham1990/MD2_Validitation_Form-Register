package com.codegym.controllers;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showFormCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "index";
        }
        userService.save(user);
        model.addAttribute("user", user);
        return "result";
    }
}
