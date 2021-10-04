package com.epam.shop_smoke.controller;

import com.epam.shop_smoke.entity.Category;
import com.epam.shop_smoke.entity.Product;
import com.epam.shop_smoke.repository.RoleRepository;
import com.epam.shop_smoke.service.CategoryService;
import com.epam.shop_smoke.service.ManufacturerService;
import com.epam.shop_smoke.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getListCategories());
        model.addAttribute("role", roleRepository.getRoleByNameRole("ADMIN"));
        model.addAttribute("products", productService.getListProducts());
        return "/admin";
    }

    @PostMapping("/admin/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.add(product);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/edit/{id}")
    public String editProductById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryService.getListCategories());
/*
        model.addAttribute("manufacturer", manufacturerService.findAll());
*/
        model.addAttribute("products", productService.getListProducts());
        return "/admin";
    }

    @PostMapping("/admin/edit")
    public String editProduct(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "/admin";
    }

    @GetMapping("/admin/delete/{idProduct}")
    public String deleteById(@PathVariable("idProduct") Long idProduct) {
            productService.delete(idProduct);
        return "redirect:/admin";
    }
}
