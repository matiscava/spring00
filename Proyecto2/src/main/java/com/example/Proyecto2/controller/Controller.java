package com.example.Proyecto2.controller;

import com.example.Proyecto2.dto.req.UserDto;
import com.example.Proyecto2.dto.res.CreateSuccessfullyDto;
import com.example.Proyecto2.service.IUserService;
import com.example.Proyecto2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    IUserService userService;
    public  Controller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserDto>> listarUsuarios(){
        return new ResponseEntity<>(userService.listarUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<CreateSuccessfullyDto> crearUsuario(
            @Valid @RequestBody UserDto userDto
//            @Valid valida el objeto userDto
    ){
        return new ResponseEntity<>(userService.crearusuario(userDto), HttpStatus.OK);
    }

    @GetMapping("/testException/{name}")
    public ResponseEntity<UserDto> testExceptionCont(
            @PathVariable String name
    ){
        return new ResponseEntity<>(userService.listarUsuario(name),HttpStatus.OK);
    }

}