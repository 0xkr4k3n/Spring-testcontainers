package com.testing.springtestcontainers.repositories;

import com.testing.springtestcontainers.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySupplierId(Long supplierId);

}