package com.example.relacionesjpa.entity.OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "address")
@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "addressId")
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
