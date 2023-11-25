package com.example.testvente.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
@Data

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    private double price;

    private boolean promotion;

    @ManyToMany(mappedBy = "products")
    private List<CategoryEntity> categories = new ArrayList<>();


}
