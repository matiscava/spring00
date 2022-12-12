package com.example.biblioteca.Repository;

import com.example.biblioteca.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
}
