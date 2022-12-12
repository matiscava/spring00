package com.example.Proyecto2.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Size(min=1, max=30, message = "El nombre debe poseer como maximo 30 caracteres y como mínimo 1")
    private String nombre;
    private String apellido;

    @Min(value=11, message = "La edad no puede ser mayor a 99")
    private int edad;
    /*
        @NotNull
        @AssertTrue
        @Size
        @Min
        @Max
        @Email

        @NotEmpty
        @NotBlank
        @Positive @PositiveOrZero
        @Negative @NegativeOrZero
        @Past @PastOrPresent
        @Future @FutureOrPresent
    */
}
