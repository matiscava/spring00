package com.example.biblioteca.controller;

import com.example.biblioteca.dto.AdminDto;
import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.service.AdminService;
import com.example.biblioteca.service.IAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private IAdminService adminService;

    public AdminController(AdminService adminService){ this.adminService = adminService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(adminService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessfullyMessageDto> crearUsuario(
            @Valid @RequestBody AdminDto adminDto
    ){
        return new ResponseEntity<>(adminService.create(adminDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessfullyMessageDto> deleteById(@RequestParam Long id){
        return new ResponseEntity<>(adminService.deleteById(id),HttpStatus.OK);
    }
}
