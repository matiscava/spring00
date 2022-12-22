package com.example.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDto {
    private String name;
    private String lastname;
    @NotNull
    private int dni;
    @Nullable
    private int phone;
    @NotNull
    private String email;
    private String password;
}
