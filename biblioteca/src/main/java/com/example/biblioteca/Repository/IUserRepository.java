package com.example.biblioteca.Repository;

import com.example.biblioteca.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
