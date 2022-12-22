package com.example.biblioteca.controller;

import com.example.biblioteca.dto.BookDto;
import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.service.BookService;
import com.example.biblioteca.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {
    private IBookService bookService;

    public BookController(BookService bookService){ this.bookService = bookService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessfullyMessageDto> create(
            @Valid @RequestBody BookDto bookDto
    ){
        return new ResponseEntity<>(bookService.create(bookDto),HttpStatus.OK);
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessfullyMessageDto> deleteById(@RequestParam Long id){
        return new ResponseEntity<>(bookService.deleteById(id), HttpStatus.OK);
    }
}
