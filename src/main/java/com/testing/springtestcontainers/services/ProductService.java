package com.testing.springtestcontainers.services;

import com.testing.springtestcontainers.entities.Product;
import com.testing.springtestcontainers.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsBySupplierId(Long supplierId) {
        return productRepository.findBySupplierId(supplierId);
    }
}
