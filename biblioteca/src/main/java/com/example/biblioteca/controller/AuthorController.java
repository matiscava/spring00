package com.example.biblioteca.controller;

import com.example.biblioteca.dto.AuthorDto;
import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.service.AuthorService;
import com.example.biblioteca.service.IAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/autor")
public class AuthorController {
    private IAuthorService authorService;

    public AuthorController(AuthorService authorService){ this.authorService = authorService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessfullyMessageDto> create(
            @Valid @RequestBody AuthorDto authorDto
            ){
        return new ResponseEntity<>(authorService.create(authorDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessfullyMessageDto> deleteById(@RequestParam Long id){
        return new ResponseEntity<>(authorService.deleteById(id), HttpStatus.OK);
    }
}
