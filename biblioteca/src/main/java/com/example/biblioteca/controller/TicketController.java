package com.example.biblioteca.controller;

import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.TicketDto;
import com.example.biblioteca.service.ITicketService;
import com.example.biblioteca.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private ITicketService ticketService;

    public TicketController(TicketService ticketService) { this.ticketService = ticketService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(ticketService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessfullyMessageDto> create(
            @Valid @RequestBody TicketDto ticketDto
    ){
        return new ResponseEntity<>(ticketService.create(ticketDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<SuccessfullyMessageDto> deleteById(@RequestParam Long id){
        return new ResponseEntity<>(ticketService.deleteById(id), HttpStatus.OK);
    }
}
