package com.epam.shop.smoke.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue
    @Column(name = "id_basket")
    private Long idBasket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "basket_product",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Basket(User user) {

    }

    public void addProduct(Product product) {
        products.add(product);
        product.getBaskets().add(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.getBaskets().remove(this);
    }
}
