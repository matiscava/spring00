package com.example.biblioteca.Repository;

import com.example.biblioteca.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
