package com.example.biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "not null")
    private String name;
    @Column(columnDefinition = "not null")
    private String lastname;
    @Column(columnDefinition = "not null", unique = true)
    private int dni;
    @Column(columnDefinition = "null")
    private String address;
    @Column(columnDefinition = "not null")
    private int age;
    @Column(columnDefinition = "not null")
    private int phone;
    @Column(columnDefinition = "not null", unique = true)
    private String email;
    @Column(columnDefinition = "not null")
    private String password;
    @Column(columnDefinition = "int default 2")
    private int maxBook;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;
}
