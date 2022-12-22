package com.example.biblioteca;

import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.User;
import com.example.biblioteca.repository.IUserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
class BibliotecaApplicationTests {

    @Autowired
    IUserRepository userRepository;
}
