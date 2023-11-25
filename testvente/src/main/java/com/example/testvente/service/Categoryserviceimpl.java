package com.example.testvente.service;

import com.example.testvente.model.CategoryEntity;
import com.example.testvente.model.ProductEntity;
import com.example.testvente.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Categoryserviceimpl implements Categoryservice{

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepo.save(category);
    }

    @Override
    public CategoryEntity update(Long id, CategoryEntity category) {

        Optional<CategoryEntity> Trouvcategorie = categoryRepo.findById(id);

        if (Trouvcategorie.isPresent()) {
            CategoryEntity newCat = categoryRepo.getReferenceById(id);

            newCat.setName(category.getName());
            return categoryRepo.save(newCat);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
