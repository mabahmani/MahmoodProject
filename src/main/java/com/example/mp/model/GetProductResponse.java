package com.example.mp.model;

import com.example.mp.entity.Order;
import com.example.mp.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class GetProductResponse {
    private int id;
    private String name;
    @JsonIgnore
    private Set<User> userSet = new HashSet<>();
    @JsonIgnore
    private Set<Order> orderSet = new HashSet<>();

    public GetProductResponse() {
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
