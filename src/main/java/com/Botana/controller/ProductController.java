package com.Botana.controller;

import com.Botana.entities.Products;
import com.Botana.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Products add(@RequestBody Products products){
        return productService.add(products);
    }

    @GetMapping
    public List<Products> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Products getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @RequestBody Products updateproducts){
        productService.updateProducstById(id,updateproducts);
        return ResponseEntity.ok("Updated Successfully");
    }
}
