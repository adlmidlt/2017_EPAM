package com.epam.shop_smoke.controller;

import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.manager.UserManager;
import com.epam.shop_smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {
    private final UserService userService;
    private final UserManager userManager;

    @Autowired
    public AuthController(UserService userService, UserManager userManager) {
        this.userService = userService;
        this.userManager = userManager;
    }

    @GetMapping("/auth")
    public String auth() {
        return "/auth";
    }

    @PostMapping("/auth")
    public String authLogin(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/auth";
        }
        User foundUser = userService.authenticate(user);
        userManager.setUser(foundUser);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
