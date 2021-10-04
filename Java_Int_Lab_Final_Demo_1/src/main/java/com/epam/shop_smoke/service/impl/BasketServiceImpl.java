package com.epam.shop_smoke.service.impl;

import com.epam.shop_smoke.entity.Basket;
import com.epam.shop_smoke.entity.Product;
import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.manager.UserManager;
import com.epam.shop_smoke.repository.BasketRepository;
import com.epam.shop_smoke.service.BasketService;
import com.epam.shop_smoke.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private ProductService productService;

    @Override
    public void addProductToBasket(Basket basket, Product product) {
        basket.addProduct(product);
        basketRepository.save(basket);
    }

    @Override
    public Product addProductToBasket(Long productId) {
        Product product = productService.getProductById(productId);
        User currentUser = userManager.getUser();
        if (currentUser != null) {
            Basket currentUserBasket = getBasketByUser(currentUser);
            if (currentUserBasket == null){
                currentUserBasket = createUserBasket(currentUser);
            }
            addProductToBasket(currentUserBasket,product);
            return product;
        }
        return null;
    }

    @Override
    public void deleteProductFromBasket(Basket basket, Product product) {
        basket.deleteProduct(product);
        basketRepository.save(basket);
    }

    @Override
    public Basket getBasketByUser(User user) {
        return basketRepository.getBasketByUser(user);
    }

    @Override
    public List<Product> getProductList(Basket basket) {
        return basket.getProductList();
    }

    @Override
    public List<Product> getProductList() {
        User currentUser = userManager.getUser();

        Basket currentUserBasket = getBasketByUser(currentUser);
        if (currentUserBasket == null){
            currentUserBasket  = createUserBasket(currentUser);
        }
        return getProductList(currentUserBasket);
    }

    @Override
    public Basket createUserBasket(User user) {
        basketRepository.save(new Basket(user));
        return basketRepository.getBasketByUser(user);
    }
}
