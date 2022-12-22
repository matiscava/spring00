package com.example.biblioteca.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private Date born_date;
    private Date death_date;
    private String info;
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "linked_title",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "title_id")
            )
    private Set<Title> titleList;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", born_date=" + born_date +
                ", death_date=" + death_date +
                ", info='" + info + '\'' +
                ", titleList=" + titleList +
                '}';
    }
}
