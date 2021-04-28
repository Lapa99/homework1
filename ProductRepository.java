package repository;

import dto.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private final static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(0L, "Роза", 12));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}