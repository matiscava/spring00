package com.example.biblioteca.Service;

import com.example.biblioteca.DTO.AdminDto;
import com.example.biblioteca.Entity.Admin;
import com.example.biblioteca.Repository.IAdminRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService implements IAdminService{
    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository){ this.adminRepository = adminRepository; }

    @Override
    public List<AdminDto> getAllAdmins() {
        Object mapper = new ObjectMapper();
        List<Admin> adminList = adminRepository.findAll();
        List<AdminDto> adminDtoList = adminList.stream().map(
                admin -> {
                    return new AdminDto(
                            admin.getName(),
                            admin.getLastname(),
                            admin.getDni(),
                            admin.getPhone(),
                            admin.getEmail(),
                            admin.getPassword()
                    );
                }
        ).collect(Collectors.toList());
        return adminDtoList;
    }

    @Override
    public void createAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setLastname(adminDto.getLastname());
        admin.setDni(adminDto.getDni());
        admin.setPhone(adminDto.getPhone());
        admin.setPassword(adminDto.getPassword());
    }


}
