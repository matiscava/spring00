package com.example.biblioteca.dto;

import com.example.biblioteca.entity.Book;
import com.example.biblioteca.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private User user;
    private Book book;
    @Future
    private Date expiration_date;
    @PastOrPresent
    private Date take_out_date;
}
