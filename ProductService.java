package com.example.store.service;

import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public void create(String title, Integer cost) {
        Product current = new Product(null, title, cost);
        productRepository.save(current);
    }
    public void delete(Product product) {
        productRepository.delete(product);
    }

}