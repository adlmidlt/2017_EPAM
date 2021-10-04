package com.epam.shop.smoke.service;

import com.epam.shop.smoke.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListProducts();
    Product getProductById(Long id);
    void add(Product product);
    void update(Product product);
    void delete(Long id);
}
