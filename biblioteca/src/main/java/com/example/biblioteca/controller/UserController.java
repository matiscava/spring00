package com.example.biblioteca.controller;


import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.service.IUserService;
import com.example.biblioteca.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private IUserService userService;

    public UserController(UserService userService){ this.userService = userService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findByIdParam(@RequestParam Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable  Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessfullyMessageDto> create(
            @Valid @RequestBody UserDto userDto
            ){
        return new ResponseEntity<>(userService.create(userDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessfullyMessageDto> deleteById(@RequestParam Long id){
        return new ResponseEntity<>(userService.deleteById(id),HttpStatus.OK);
    }
}
