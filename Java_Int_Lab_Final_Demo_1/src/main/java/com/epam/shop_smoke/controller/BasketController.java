package com.epam.shop_smoke.controller;

import com.epam.shop_smoke.entity.Product;
import com.epam.shop_smoke.manager.UserManager;
import com.epam.shop_smoke.service.BasketService;
import com.epam.shop_smoke.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BasketController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserManager userManager;
    @Autowired
    private BasketService basketService;

    @GetMapping("basket")
    private String basket(Model model) {
        model.addAttribute("basket", basketService.getProductList());
        return "basket";
    }

    @PostMapping("basket/add")
    public Product addToBasket(@RequestBody Long productId) {
        return basketService.addProductToBasket(productId);
    }

    @PostMapping("basket/delete")
    public Product deleteFromBasket(@RequestBody Long productId) {
        basketService.deleteProductFromBasket(
                basketService.getBasketByUser(userManager.getUser()),
                productService.getProductById(productId));
        return productService.getProductById(productId);
    }

    @PostMapping("basket")
    public List<Product> getBasketProductList() {
        return basketService.getProductList();
    }
}
