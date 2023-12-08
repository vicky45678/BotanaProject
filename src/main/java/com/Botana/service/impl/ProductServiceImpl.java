package com.Botana.service.impl;

import com.Botana.entities.Products;
import com.Botana.repository.ProductRepository;
import com.Botana.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products add(Products products) {
        return productRepository.save(products);
    }

    @Override
    public List<Products> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Products getById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProducstById(Long id, Products products) {
       Products products1= productRepository.findById(id).orElse(null);

       if (products1 !=null){
           products1.setProductId(products.getProductId());
           products1.setProductName(products.getProductName());

           productRepository.save(products);
       }

    }
}
