package com.example.relacionesjpa.entity.OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

}
