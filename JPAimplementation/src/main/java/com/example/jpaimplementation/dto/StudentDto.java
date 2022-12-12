package com.example.jpaimplementation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
//    private Long id;
    private String dni;
    private String name;
    private String lastname;


}
