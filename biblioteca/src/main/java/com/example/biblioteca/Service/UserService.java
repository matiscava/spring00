package com.example.biblioteca.Service;

import com.example.biblioteca.DTO.UserDto;
import com.example.biblioteca.Entity.User;
import com.example.biblioteca.Repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserService implements IUserService{
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository){ this.userRepository=userRepository; }

    @Override
    public List<UserDto> getAllUsers() {
        Object mapper = new ObjectMapper();
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(
                user -> {
                    return new UserDto(
                            user.getName(),
                            user.getLastname(),
                            user.getDni(),
                            user.getAddress(),
                            user.getAge(),
                            user.getPhone(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getMaxBook(),
                            user.getActive_orders()
                    );
                }
        ).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void creatUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setDni(userDto.getDni());
        user.setAddress(userDto.getAddress());
        user.setAge(userDto.getAge());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMaxBook(userDto.getMaxBook());
        user.setActive_orders(userDto.getActive_orders());

    }
}
