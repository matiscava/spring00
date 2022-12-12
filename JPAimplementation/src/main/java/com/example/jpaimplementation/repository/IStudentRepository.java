package com.example.jpaimplementation.repository;

import com.example.jpaimplementation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
//    Student findByName(String name);
}
