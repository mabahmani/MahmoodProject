package com.example.mp.model;

import com.example.mp.entity.Product;
import com.example.mp.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddOrderResponse {
    private int id;

    private String name;

    @JsonIgnore
    private User user;
    @JsonIgnore
    private Product product;

    public AddOrderResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

