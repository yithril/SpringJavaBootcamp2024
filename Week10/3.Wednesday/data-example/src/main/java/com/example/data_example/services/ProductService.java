package com.example.data_example.services;

import com.example.data_example.models.Product;
import com.example.data_example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        var products = productRepository.findAll();

        return products;
    }

    public List<Product> findProductsByName(String searchTerm){
        var products = productRepository.findByNameContainingIgnoreCase(searchTerm);

        return products;
    }
}
