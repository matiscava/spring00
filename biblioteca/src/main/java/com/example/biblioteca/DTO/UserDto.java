package com.example.biblioteca.DTO;

import com.example.biblioteca.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    private String name;
    private String lastname;
    private int dni;
    private String address;
    private int age;
    private Long phone;
    private String email;
    private String password;
    private int maxBook;
    private Set<Order> active_orders;

}
