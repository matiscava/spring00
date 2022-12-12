package com.example.biblioteca.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "title")
    private List<Book> bookList;
    @ManyToMany(mappedBy = "titleList")
    private Set<Author> authors;
}
