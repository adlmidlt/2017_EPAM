package com.epam.shop.smoke.repository;

import com.epam.shop.smoke.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductByIdProduct(Long id);
}
