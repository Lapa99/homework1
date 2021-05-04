package com.example.springboot.repository;

import com.example.springboot.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private final ProductDao productDao;
    public List<Product> findAll() {
        productDao.init();
        List<Product> current = productDao.findAll();
        productDao.shutdown();
        return current;
    }
}