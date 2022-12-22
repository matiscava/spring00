package com.example.biblioteca.dto;

import com.example.biblioteca.entity.Author;
import com.example.biblioteca.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitleDto {
    private String title;
    private List<Book> bookList;
    private Set<Author> authors;

    @Override
    public String toString() {
        return "TitleDto{" +
                "title='" + title + '\'' +
                ", bookList=" + bookList +
                ", authors=" + authors +
                '}';
    }
}
