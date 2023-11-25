package com.example.testvente.controller;

import com.example.testvente.Exceptions.CategoryException;
import com.example.testvente.model.CategoryEntity;

import com.example.testvente.service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class categoryController {

    @Autowired
    private Categoryservice categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long id) {
        try {
            CategoryEntity category = categoryService.findById(id);
            return ResponseEntity.ok(category);
        } catch (CategoryException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found: " + e.getMessage());
        }
    }

    @GetMapping
    //@PreAuthorize("hasRole('ROLE_user')")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        List<CategoryEntity> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category) {
        CategoryEntity createdCategory = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity updatedCategory) {
        CategoryEntity updated = categoryService.update(id, updatedCategory);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
