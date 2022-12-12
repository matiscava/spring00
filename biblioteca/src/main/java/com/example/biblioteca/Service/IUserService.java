package com.example.biblioteca.Service;

import com.example.biblioteca.DTO.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUsers();
    void creatUser(UserDto userDto);
}
