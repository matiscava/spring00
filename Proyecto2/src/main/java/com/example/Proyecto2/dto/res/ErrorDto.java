package com.example.Proyecto2.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
    private int statusCode;
    private String message;
}
