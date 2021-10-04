package com.epam.shop.smoke.controller;

import com.epam.shop.smoke.manager.UserManager;
import com.epam.shop.smoke.service.CategoryService;
import com.epam.shop.smoke.service.ProductService;
import com.epam.shop.smoke.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final ProductService productService;

    private final CategoryService categoryService;

    private final RoleService roleService;

    private final UserManager userManager;

    @Autowired
    public IndexController(ProductService productService, CategoryService categoryService, RoleService roleService, UserManager userManager) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.roleService = roleService;
        this.userManager = userManager;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", userManager.getUser());
        model.addAttribute("role", roleService.getRoleByNameRole("ADMIN"));
        model.addAttribute("product", productService.getListProducts());
        model.addAttribute("categories", categoryService.getListCategories());
        return "/index";
    }
}
