package com.example.biblioteca.dto;

import com.example.biblioteca.entity.Ticket;
import com.example.biblioteca.entity.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int edition;
    private int year;
    private String editorial;
    private Title title;
    private boolean enabled;
    @Column(nullable = true)
    private Ticket ticket;

}
