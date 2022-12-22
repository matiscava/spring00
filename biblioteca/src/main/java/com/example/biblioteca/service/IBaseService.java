package com.example.biblioteca.service;

import com.example.biblioteca.dto.SuccessfullyMessageDto;

import java.util.List;

public interface IBaseService<T> {
    List<T> getAll();
    SuccessfullyMessageDto create(T object);
    T getById(Long id);
    void update(Long id, T object);
    SuccessfullyMessageDto deleteById(Long id);
}
