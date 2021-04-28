package service;

import dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product get(Long id) {
        return productRepository.findById(0L);
    }
}