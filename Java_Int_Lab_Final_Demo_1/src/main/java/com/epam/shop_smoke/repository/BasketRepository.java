package com.epam.shop_smoke.repository;

import com.epam.shop_smoke.entity.Basket;
import com.epam.shop_smoke.entity.Product;
import com.epam.shop_smoke.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket getBasketByUser(User user);

}
