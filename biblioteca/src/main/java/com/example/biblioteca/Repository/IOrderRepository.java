package com.example.biblioteca.Repository;

import com.example.biblioteca.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
