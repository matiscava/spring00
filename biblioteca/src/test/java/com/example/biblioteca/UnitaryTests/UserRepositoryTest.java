package com.example.biblioteca.UnitaryTests;

import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.User;
import com.example.biblioteca.repository.IUserRepository;
import com.example.biblioteca.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
public class UserRepositoryTest {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void createUserTestOk(){
        UserDto userDto = new UserDto();
        userDto.setName("Jorge");
        userDto.setLastname("Corona");
        userDto.setDni(4126987);
        userDto.setAddress("Calle 234");
        userDto.setAge(32);
        userDto.setPhone(114897652);
        userDto.setEmail("jorgecorona@mail.com");
        userDto.setPassword("jorge123");

        User user = new User();
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setDni(userDto.getDni());
        user.setAddress(userDto.getAddress());
        user.setAge(userDto.getAge());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setId(0L);

        User userTest = userRepository.save(user);
        Assert.assertTrue(userTest.getName() == user.getName());
        Assert.assertTrue( userTest.getId() == 0 );

        SuccessfullyMessageDto realMessage = userService.create(userDto);
        SuccessfullyMessageDto expectedMessage = new SuccessfullyMessageDto("El Usuario se creó correctamente");

        Assert.assertTrue( expectedMessage.getMessage() == realMessage.getMessage());
    }

    @Test
    void findByIdTestOk(){
        User user = userRepository.findById(1L).get();

        Assert.assertTrue(user!=null);
        Assert.assertTrue(user.getName().equals("Homero"));

        UserDto userDto = userService.getById(1L);
        Assert.assertTrue(userDto.getLastname().equals("Simpson"));
    }

    @Test
    void findAllTest(){
        List<User> userList = userRepository.findAll();

        Assert.assertFalse(userList.isEmpty());
        System.out.println(userList.size());
        Assert.assertTrue(userList.size()==3);
    }

}
