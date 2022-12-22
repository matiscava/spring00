package com.example.biblioteca.dto;

import com.example.biblioteca.entity.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private String name;
    private String lastname;
    @NotNull
    private Date born_date;
    @Nullable
    private Date death_date;
    private String info;
    private Set<Title> titleList;
}
