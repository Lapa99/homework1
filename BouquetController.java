package com.example.store.controller;

import com.example.store.exception.ProductNotFoundException;
import com.example.store.exception.ProductsErrorResponse;
import com.example.store.model.Bouquet;
import com.example.store.service.BouquetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/catalog")
public class BouquetController {

    private final BouquetService bouquetService;

    @GetMapping("/{id}")
    public Bouquet findById(@PathVariable Long id) {
        return bouquetService.findById(id);
    }
    @GetMapping
    public Page<Bouquet> findAll(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "page-size", defaultValue = "2") Integer pageSize) {
        return bouquetService.findAll(pageNumber, pageSize);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Bouquet bouquet) {
        bouquetService.save(bouquet);
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        bouquetService.delete(id);
        return HttpStatus.OK.value();
    }
    @PutMapping
    public void update(@RequestBody Bouquet bouquet) {
        bouquetService.save(bouquet);
    }
    @ExceptionHandler
    public ResponseEntity<ProductsErrorResponse> handleException(ProductNotFoundException exc) {
        ProductsErrorResponse productsErrorResponse = new ProductsErrorResponse();
        productsErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        productsErrorResponse.setMessage(exc.getMessage());
        productsErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(productsErrorResponse, HttpStatus.NOT_FOUND);
    }
}