package com.example.Proyecto2.controller;

import com.example.Proyecto2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloWorld {

    @Autowired
    IUserService userService;

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<?> sayHello(@PathVariable String name){
        return new ResponseEntity<>(userService.saludar(name), HttpStatus.OK);
    }
}
