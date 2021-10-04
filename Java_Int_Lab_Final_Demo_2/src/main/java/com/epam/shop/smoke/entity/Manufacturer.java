package com.epam.shop.smoke.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue
    @Column(name = "id_manufacturer")
    private Long idManufacturer;

    @Column(name = "name")
    private String nameManufacturer;

    @OneToMany(
            mappedBy = "manufacturer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Product> products;
}
