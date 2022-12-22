package com.example.biblioteca.service;

import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.Ticket;
import com.example.biblioteca.entity.User;
import com.example.biblioteca.repository.ITicketRepository;
import com.example.biblioteca.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    private IUserRepository userRepository;
    private ITicketRepository ticketRepository;

    public UserService(IUserRepository userRepository, ITicketRepository ticketRepository){
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<UserDto> getAll() {
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
                            user.getTickets()
                    );
                }
        ).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public SuccessfullyMessageDto create(UserDto userDto) {
        User user = new User();

//        List<Ticket> ticketList = new ArrayList<>();
        System.out.println("userDto tickets: "+userDto.getTickets());
//        if (userDto.getTickets() != null){
//            userDto.getTickets().stream().map(
//                    ticket -> {
//                        ticketList.add(ticketRepository.findById(ticket.getId()).get());
//                        return ticketList;
//                    }
//            ).collect(Collectors.toList());
//        }
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setDni(userDto.getDni());
        user.setAddress(userDto.getAddress());
        user.setAge(userDto.getAge());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMaxBook(userDto.getMaxBook());
        user.setTickets(userDto.getTickets());
        userRepository.save(user);
        return new SuccessfullyMessageDto("El Usuario se creó correctamente");

    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).get();
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
                user.getTickets()
        );
    }

    @Override
    public void update(Long id, UserDto object) {

    }

    @Override
    public SuccessfullyMessageDto deleteById(Long id) {
        userRepository.deleteById(id);
        return new SuccessfullyMessageDto("El usuario id: "+id+" se eliminó correctamente");
    }
}
