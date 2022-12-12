package com.example.Proyecto2.entities;

import jakarta.persistence.*; // usó javax.persistence.*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
//    @Column(nullable = false, length = 30)
    private String nombre;
    private String apellido;
    private int edad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUser;
}

