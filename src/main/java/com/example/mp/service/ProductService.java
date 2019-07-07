package com.example.mp.service;

import com.example.mp.entity.Product;
import com.example.mp.entity.User;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}
