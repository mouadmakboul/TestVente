package com.example.testvente.service;

import com.example.testvente.Exceptions.Productexception;
import com.example.testvente.model.ProductEntity;
import com.example.testvente.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Productserviceimpl implements Productservice {

    @Autowired
    private productRepo pr;
    @Override
    public ProductEntity findById(Long id) {
        return pr.findById(id)
                .orElseThrow(() -> new Productexception("Product with ID " + id + " not found"));
    }


    @Override
    public List<ProductEntity> findAll() {
        return pr.findAll();
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return pr.save(product);
    }

    @Override
    public ProductEntity update( Long id ,ProductEntity updatedProduct) {
        Optional<ProductEntity> Trouvproduct = pr.findById(id);

        if (Trouvproduct.isPresent()) {
            ProductEntity newPr = pr.getById(id);

            newPr.setName(updatedProduct.getName());
            newPr.setPrice(updatedProduct.getPrice());
            newPr.setPromotion(updatedProduct.isPromotion());
            return pr.save(newPr);
        } else {
            return null;
        }}

    @Override
    public void delete(Long id) {
         pr.deleteById(id);

    }
}
