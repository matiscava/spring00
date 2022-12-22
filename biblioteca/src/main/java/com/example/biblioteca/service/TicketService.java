package com.example.biblioteca.service;

import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.TicketDto;
import com.example.biblioteca.entity.Book;
import com.example.biblioteca.entity.Ticket;
import com.example.biblioteca.entity.User;
import com.example.biblioteca.repository.IBookRepository;
import com.example.biblioteca.repository.ITicketRepository;
import com.example.biblioteca.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService{

    private ITicketRepository ticketRepository;
    private IBookRepository bookRepository;
    private IUserRepository userRepository;

    public  TicketService(ITicketRepository ticketRepository, IBookRepository bookRepository, IUserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TicketDto> getAll() {
        List<Ticket> ticketList = ticketRepository.findAll();
        List<TicketDto> ticketDtoList = ticketList.stream().map(
                ticket -> {
                    return new TicketDto(
                            ticket.getUser(),
                            ticket.getBook(),
                            ticket.getExpiration_date(),
                            ticket.getTake_out_date()
                    );
                }
        ).collect(Collectors.toList());
        return ticketDtoList;
    }

    @Override
    public SuccessfullyMessageDto create(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        User user = userRepository.findById(ticketDto.getUser().getId()).get();
        Book book = bookRepository.findById(ticketDto.getBook().getId()).get();
        ticket.setUser(user);
        ticket.setBook(book);
        ticket.setExpiration_date(ticketDto.getExpiration_date());
        ticket.setTake_out_date(ticketDto.getTake_out_date());
        ticketRepository.save(ticket);
        return new SuccessfullyMessageDto("El Ticket se generó correctamente");

    }

    @Override
    public TicketDto getById(Long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        return new TicketDto(
                ticket.getUser(),
                ticket.getBook(),
                ticket.getExpiration_date(),
                ticket.getTake_out_date()
        );
    }

    @Override
    public void update(Long id, TicketDto object) {

    }

    @Override
    public SuccessfullyMessageDto deleteById(Long id) {
        ticketRepository.deleteById(id);
        return new SuccessfullyMessageDto("El Ticket id: "+id+" se eliminó correctamente");
    }
}
