package com.example.Proyecto2.service;

import com.example.Proyecto2.dto.req.HelloDto;
import com.example.Proyecto2.dto.req.UserDto;
import com.example.Proyecto2.dto.res.CreateSuccessfullyDto;
import com.example.Proyecto2.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDto> listarUsuarios();
    CreateSuccessfullyDto crearusuario(UserDto userDto);
    UserDto listarUsuario(String name);
    HelloDto saludar(String name);
}
