package com.example.biblioteca.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="admin")
public class Admin {
    @Id
    private Long id;
    private String name;
    private String lastname;
    private int dni;
    private Long phone;
    private String email;
    private String password;
}
