package com.example.Proyecto2.repository;

import com.example.Proyecto2.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAllUsers();
    void saveUser (User user);
    Optional<User> findUserByName(String name);
}
