package com.example.mp.service;

import com.example.mp.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(int id);

    void save(Order order);
}
