package com.example.testvente.repository;

import com.example.testvente.model.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {

}
