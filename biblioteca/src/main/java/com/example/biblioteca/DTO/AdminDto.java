package com.example.biblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDto {
    private String name;
    private String lastname;
    private int dni;
    private Long phone;
    private String email;
    private String password;
}
