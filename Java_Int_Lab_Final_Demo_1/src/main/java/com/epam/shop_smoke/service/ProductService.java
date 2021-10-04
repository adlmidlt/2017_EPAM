package com.epam.shop_smoke.service;

import com.epam.shop_smoke.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListProducts();
    Product getProductById(Long id);
    void add(Product product);
    void update(Product product);
    void delete(Long id);

}
