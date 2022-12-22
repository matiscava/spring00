package com.example.biblioteca.controller;

import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.TitleDto;
import com.example.biblioteca.service.ITitleService;
import com.example.biblioteca.service.TitleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/title")
public class TitleController {
    private ITitleService titleService;

    public TitleController(TitleService titleService){ this.titleService = titleService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(titleService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessfullyMessageDto> create(
            @Valid @RequestBody TitleDto titleDto
            ){
        return new ResponseEntity<>(titleService.create(titleDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessfullyMessageDto> deleteById(@RequestParam Long id){
        return new ResponseEntity<>(titleService.deleteById(id), HttpStatus.OK);
    }
}
