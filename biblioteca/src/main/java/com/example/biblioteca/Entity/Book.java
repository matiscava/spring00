package com.example.biblioteca.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String edition;
    private int year;
    private String editorial;
    @ManyToOne
    @JoinColumn(name = "title_id",nullable = false)
    private Title title;
    private boolean enabled;

    @OneToOne(mappedBy = "book")
    private Order order;


}
