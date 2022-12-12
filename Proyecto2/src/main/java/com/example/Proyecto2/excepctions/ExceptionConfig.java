package com.example.Proyecto2.excepctions;

import com.example.Proyecto2.dto.res.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ExceptionConfig {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> notFoundException(UserNotFoundException ex){
        ErrorDto errorDto = new ErrorDto(404, ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validacionErronea (MethodArgumentNotValidException ex){
        ErrorDto errorDto = new ErrorDto(400, ex.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
