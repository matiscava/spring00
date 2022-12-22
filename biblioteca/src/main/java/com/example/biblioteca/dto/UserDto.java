package com.example.biblioteca.dto;

import com.example.biblioteca.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    @NotNull
    private int dni;
    @Nullable
    private String address;
    @Min(value = 16,message = "La edad no puede ser menor a 16")
    @Max(value = 110, message = "La edad no peude ser mayor a 110")
    private int age;
    @Nullable
    private int phone;
    private String email;
    private String password;
    private int maxBook;
    private List<Ticket> tickets;

}
