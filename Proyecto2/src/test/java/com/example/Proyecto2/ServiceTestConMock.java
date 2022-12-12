package com.example.Proyecto2;

import com.example.Proyecto2.dto.req.UserDto;
import com.example.Proyecto2.entities.User;
import com.example.Proyecto2.repository.IUserRepository;
import com.example.Proyecto2.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTestConMock {
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void listarUsuariosTestOk(){
        // Arrange
        List<User> userListReturn = new ArrayList<>();
        userListReturn.add(new User("Matias", "Scavarelli", 32,1));
        userListReturn.add(new User("Lionel", "Messi", 35,2));
        userListReturn.add(new User("Carmen", "Electra", 47,3));
        userListReturn.add(new User("Sergio", "Denis", 64,4));

        List<UserDto> listaEsperada = new ArrayList<>();
        listaEsperada.add(new UserDto("Matias", "Scavarelli", 32));
        listaEsperada.add(new UserDto("Lionel", "Messi", 35));
        listaEsperada.add(new UserDto("Carmen", "Electra", 47));
        listaEsperada.add(new UserDto("Sergio", "Denis", 64));

        // Act
        when(userRepository.findAllUsers()).thenReturn(userListReturn);
        List<UserDto> listarObtenida = userService.listarUsuarios();

        // Assert
//        Assertions.assertEquals(listaEsperada.size(), listarObtenida.size());
//        Assertions.assertEquals(listaEsperada.get(0), listarObtenida.get(0));
        Assertions.assertAll(()->{
            assertEquals(listaEsperada.size(), listarObtenida.size());
            assertEquals(listaEsperada.get(0), listarObtenida.get(0));
        });
    }
}
