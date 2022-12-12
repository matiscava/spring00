package com.example.biblioteca.Repository;

import com.example.biblioteca.Entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITitleRepository extends JpaRepository<Title,Long> {
}
