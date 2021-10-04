package com.epam.shop_smoke.controller;

import com.epam.shop_smoke.entity.Role;
import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.exception.UserAlreadyExistsException;
import com.epam.shop_smoke.manager.UserManager;
import com.epam.shop_smoke.repository.RoleRepository;
import com.epam.shop_smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserManager userManager;

    @Autowired
    public RegController(UserService userService, RoleRepository roleRepository, UserManager userManager) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userManager = userManager;
    }

    @GetMapping("/registration")
    public String reg() {
        return "/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/registration";
        }
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getOne(2L));
        user.setRoles(roles);
        userService.addUser(user);
        userManager.setUser(user);
        return "redirect:/auth";
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handlerUserAlreadyExistsException(Model model) {
        model.addAttribute("errorUserAlreadyExistsException", "Пользователь уже зарегистрирован!");
        return "/registration";
    }
}
