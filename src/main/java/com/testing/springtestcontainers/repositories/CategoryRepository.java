package com.testing.springtestcontainers.repositories;

import com.testing.springtestcontainers.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}