package com.epam.shop_smoke.controller;

import com.epam.shop_smoke.manager.UserManager;
import com.epam.shop_smoke.service.CategoryService;
import com.epam.shop_smoke.service.ProductService;
import com.epam.shop_smoke.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserManager userManager;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", userManager.getUser());
        model.addAttribute("role", roleService.getRoleByNameRole("ADMIN"));
        model.addAttribute("product", productService.getListProducts());
        model.addAttribute("categories", categoryService.getListCategories());
        return "/index";
    }
}
