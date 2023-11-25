package com.example.testvente.repository;


import com.example.testvente.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo extends JpaRepository<ProductEntity,Long> {


}
