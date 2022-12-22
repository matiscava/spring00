package com.example.biblioteca.MockTest;

import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.User;
import com.example.biblioteca.repository.ITicketRepository;
import com.example.biblioteca.repository.IUserRepository;
import com.example.biblioteca.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTestConMock {
    @Mock
    private IUserRepository userRepository;
    @Mock
    private ITicketRepository ticketRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getAllUserTestOk(){
        List<User> userListReturn = new ArrayList<>();
//        Crear usuario 1
        User user1 = new User();
        user1.setId(0L);
        user1.setName("Matias");
        user1.setLastname("Scavarelli");
        user1.setAge(32);
        user1.setDni(2233456);
        user1.setAddress("Calle falsa 123");
        user1.setPassword("mati123");
        user1.setPhone(45678921);
        user1.setEmail("mscava@mail.com");
        user1.setTickets(new ArrayList<>());
        user1.setMaxBook(3);
//        Crear usuario 2
        User user2 = new User();
        user2.setId(1L);
        user2.setName("Jose");
        user2.setLastname("Perez");
        user2.setAge(17);
        user2.setDni(11745698);
        user2.setAddress("Av. Cabildo 123");
        user2.setPassword("jose123");
        user2.setPhone(1174136987);
        user2.setEmail("jperez@mail.com");
        user2.setTickets(new ArrayList<>());
        user2.setMaxBook(2);
//        Crear usuario 3
        User user3 = new User();
        user3.setId(2L);
        user3.setName("Susana");
        user3.setLastname("Gimenez");
        user3.setAge(61);
        user3.setDni(5632147);
        user3.setAddress("Cerruti 741");
        user3.setPassword("susana123");
        user3.setPhone(114789625);
        user3.setEmail("sgimenez@mail.com");
        user3.setTickets(new ArrayList<>());
        user3.setMaxBook(2);

        userListReturn.add(user1);
        userListReturn.add(user2);
        userListReturn.add(user3);

        List<UserDto> listaEsperada = new ArrayList<>();
        listaEsperada.add(
                new UserDto(
                "Matias"
                ,"Scavarelli"
                ,2233456
                ,"Av. Cabildo 123"
                ,32
                ,45678921
                ,"jperez@mail.com"
                ,"mati123"
                ,3
                ,new ArrayList<>()));
        listaEsperada.add(
                new UserDto("Jose"
                ,"Perez"
                ,11745698
                ,"Av. Cabildo 123"
                ,17
                ,1174136987
                ,"jperez@mail.com"
                ,"jose123"
                ,2
                ,new ArrayList<>()
                ));
        listaEsperada.add(
                new UserDto("Susana"
                ,"Gimenez"
                ,5632147
                ,"Cerruti 741"
                ,61
                ,114789625
                ,"sgimenez@mail.com"
                ,"susana123"
                ,2
                ,new ArrayList<>()));

        when(userRepository.findAll()).thenReturn(userListReturn);
        List<UserDto> listaObtenida = userService.getAll();

        Assertions.assertEquals(listaEsperada.size(), listaObtenida.size());
        Assertions.assertEquals(listaEsperada.get(0).getDni(),listaObtenida.get(0).getDni());

    }
}
