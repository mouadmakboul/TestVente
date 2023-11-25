package com.example.testvente.service;

import com.example.testvente.model.CategoryEntity;
import com.example.testvente.model.ProductEntity;
import com.example.testvente.repository.CategoryRepo;

import java.util.List;

public interface Categoryservice {

    CategoryEntity findById(Long id);

    List<CategoryEntity> findAll();

    CategoryEntity save(CategoryEntity category);

    CategoryEntity update(Long id, CategoryEntity category);

    void delete(Long id);
}
