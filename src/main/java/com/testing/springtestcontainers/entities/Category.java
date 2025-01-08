package com.testing.springtestcontainers.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}