package com.Botana.service;

import com.Botana.entities.Products;

import java.util.List;

public interface ProductService {

    Products add(Products products);

    List<Products> getAll();

    Products getById(Long id);

    void deleteById(Long id);

    void updateProducstById(Long id, Products updateproducts);
}
