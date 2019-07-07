package com.example.mp.service;

import com.example.mp.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User findByUsername(String username);

    void save(User user);
}
