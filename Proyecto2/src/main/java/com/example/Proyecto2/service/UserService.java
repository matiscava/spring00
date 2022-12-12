package com.example.Proyecto2.service;

import com.example.Proyecto2.dto.req.HelloDto;
import com.example.Proyecto2.dto.req.UserDto;
import com.example.Proyecto2.dto.res.CreateSuccessfullyDto;
import com.example.Proyecto2.entities.User;
import com.example.Proyecto2.excepctions.UserNotFoundException;
import com.example.Proyecto2.repository.IUserRepository;
import com.example.Proyecto2.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.Proyecto2.utils.Utils.cargar;

@Service
public class UserService implements IUserService {
    IUserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> listarUsuarios() {
        List<User> userList = userRepository.findAllUsers();
        List<UserDto> userDtoList = userList.stream().map(user -> {
            return new UserDto(user.getNombre(),user.getApellido(),user.getEdad());
        }).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public CreateSuccessfullyDto crearusuario(UserDto userDto) {
        // Transformar el userDto en User
        User user = new User(userDto.getNombre(), userDto.getApellido(), userDto.getEdad());
        // Llamar un méodo del repositorio para guardar al user
        userRepository.saveUser(user);
        // crear respuesta
        CreateSuccessfullyDto createS = new CreateSuccessfullyDto("El usuario fue creado correctamente.");
        return createS;
    }

    @Override
    public UserDto listarUsuario(String name) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<User> user = userRepository.findUserByName(name);
        if( user.isPresent()){
            User u = user.get();
            UserDto userDto = mapper.convertValue(u, UserDto.class);
            return userDto;
        }
        throw new UserNotFoundException("El usuario no se encontró");
    }
    @Override
    public HelloDto saludar(String name){
        return new HelloDto("Hola "+name+"!!");
    }
}
