package com.example.data_example.repositories;

import com.example.data_example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Derived Query
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByNameAndDescriptionContainingIgnoreCase(String name, String description);
}
