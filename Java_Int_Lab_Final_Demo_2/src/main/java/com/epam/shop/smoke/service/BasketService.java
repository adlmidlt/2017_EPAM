package com.epam.shop.smoke.service;

import com.epam.shop.smoke.entity.Basket;
import com.epam.shop.smoke.entity.Product;
import com.epam.shop.smoke.entity.User;

import java.util.List;

public interface BasketService {
    void addProductToBasket(Basket basket, Product product);
    Product addProductToBasket(Long productId);
    void deleteProductFromBasket(Basket basket, Product product);
    Basket getBasketByUser(User user);
    List<Product> getProductList(Basket basket);
    List<Product> getProductList();
    Basket createUserBasket(User user);
}
