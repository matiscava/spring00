package com.example.biblioteca.service;

import com.example.biblioteca.dto.AdminDto;
import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.entity.Admin;
import com.example.biblioteca.repository.IAdminRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdminService implements IAdminService{
    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository){ this.adminRepository = adminRepository; }

    @Override
    public List<AdminDto> getAll() {
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
    public SuccessfullyMessageDto create(AdminDto adminDto) {
        System.out.println(adminDto.toString());
        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setLastname(adminDto.getLastname());
        admin.setDni(adminDto.getDni());
        admin.setPhone(adminDto.getPhone());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        adminRepository.save(admin);
        return new SuccessfullyMessageDto("El admin se creó correctamente");
    }

    @Override
    public AdminDto getById(Long id) {;
        Admin admin = adminRepository.findById(id).get();
        return new AdminDto(
                            admin.getName(),
                            admin.getLastname(),
                            admin.getDni(),
                            admin.getPhone(),
                            admin.getEmail(),
                            admin.getPassword()
        );
    }

    @Override
    public void update(Long id, AdminDto object) {

    }

    @Override
    public SuccessfullyMessageDto deleteById(Long id) {
        adminRepository.deleteById(id);
        return new SuccessfullyMessageDto("El admin id: "+id+" se eliminó correctamente");
    }
}
