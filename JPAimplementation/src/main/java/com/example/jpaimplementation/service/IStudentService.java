package com.example.jpaimplementation.service;

import com.example.jpaimplementation.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    List<StudentDto> obtenerEstudiantes();
//    StudentDto obtenerEstudiante(String name);
}
