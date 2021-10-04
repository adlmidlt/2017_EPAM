package com.epam.shop.smoke.repository;

import com.epam.shop.smoke.entity.Basket;
import com.epam.shop.smoke.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket getBasketByUser(User user);
}
