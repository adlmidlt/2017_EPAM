package com.epam.shop.smoke.service.impl;

import com.epam.shop.smoke.entity.Product;
import com.epam.shop.smoke.repository.ProductRepository;
import com.epam.shop.smoke.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getListProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductByIdProduct(id);
    }

    @Override
    public void add(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void update(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
