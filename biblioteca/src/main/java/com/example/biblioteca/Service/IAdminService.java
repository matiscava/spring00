package com.example.biblioteca.Service;

import com.example.biblioteca.DTO.AdminDto;

import java.util.List;

public interface IAdminService {
    List<AdminDto> getAllAdmins();
    void createAdmin(AdminDto adminDto);
}
