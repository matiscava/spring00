package com.example.biblioteca.Repository;

import com.example.biblioteca.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Long> {
}
