package com.example.store.controller;

import com.example.store.model.Product;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }
    @PostMapping("/products")
    public void create(String title, Integer cost) {
        productService.create(title, cost);
    }
    @GetMapping("/products/delete/{id}")
    public void delete(Product product) {
        productService.delete(product);
    }
}