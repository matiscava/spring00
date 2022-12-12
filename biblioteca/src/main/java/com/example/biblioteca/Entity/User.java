package com.example.biblioteca.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    private Long id;
    private String name;
    private String lastname;
    private int dni;
    private String address;
    private int age;
    private Long phone;
    private String email;
    private String password;
    private int maxBook;
    @OneToMany(mappedBy = "user")
    private Set<Order> active_orders;
}
