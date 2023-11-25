package com.example.testvente.service;

import com.example.testvente.model.ProductEntity;

import java.util.List;

public interface Productservice {

    ProductEntity findById(Long id);

    List<ProductEntity> findAll();

    ProductEntity save(ProductEntity product);

    ProductEntity update( Long id ,ProductEntity product);

    void delete(Long id);

}
