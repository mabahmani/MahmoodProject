package com.example.mp.service;

import com.example.mp.dao.ProductRepository;
import com.example.mp.entity.Product;
import com.example.mp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.getOne(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}
