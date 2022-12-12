package com.example.jpaimplementation.service;

import com.example.jpaimplementation.dto.StudentDto;
import com.example.jpaimplementation.entity.Student;
import com.example.jpaimplementation.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> obtenerEstudiantes(){
        ObjectMapper mapper = new ObjectMapper();
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = studentList.stream().map(
                student -> {
                    return new StudentDto(
//                            student.getId(),
                            student.getDni(),
                            student.getName(),
                            student.getLastname()
                    );
                }
        ).collect(Collectors.toList());
        return studentDtoList;
    }

}
