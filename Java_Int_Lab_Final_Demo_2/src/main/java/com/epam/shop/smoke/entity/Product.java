package com.epam.shop.smoke.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name")
    private String nameProduct;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "date_devilery")
    private LocalDate dateDevilery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToMany(mappedBy = "products")
    private List<Basket> baskets;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}
