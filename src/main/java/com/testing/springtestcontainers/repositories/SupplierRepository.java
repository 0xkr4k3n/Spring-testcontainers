package com.testing.springtestcontainers.repositories;

import com.testing.springtestcontainers.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}