package com.example.biblioteca.entity;

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
    private int edition;
    private int year;
    private String editorial;
    @ManyToOne
    @JoinColumn(name = "title_id",nullable = false)
    private Title title;
    private boolean enabled;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="ticket_id", nullable = true)
    private Ticket ticket;


}
