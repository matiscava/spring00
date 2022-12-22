package com.example.biblioteca.service;

import com.example.biblioteca.dto.BookDto;
import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.entity.Book;
import com.example.biblioteca.entity.Title;
import com.example.biblioteca.repository.IBookRepository;
import com.example.biblioteca.repository.ITitleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService{

    private IBookRepository bookRepository;
    private ITitleRepository titleRepository;
    public BookService(IBookRepository bookRepository, ITitleRepository titleRepository) {
        this.bookRepository = bookRepository;
        this.titleRepository = titleRepository;
    }

    @Override
    public List<BookDto> getAll() {
        Object mapper = new ObjectMapper();
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> bookDtoList = bookList.stream().map(
                book -> {
                    return new BookDto(
                            book.getEdition(),
                            book.getYear(),
                            book.getEditorial(),
                            book.getTitle(),
                            book.isEnabled(),
                            book.getTicket()
                    );
                }
        ).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public SuccessfullyMessageDto create(BookDto bookDto) {
        Book book = new Book();
        Title title = titleRepository.findById(bookDto.getTitle().getId()).get();
        book.setEdition(bookDto.getEdition());
        book.setYear(bookDto.getYear());
        book.setEditorial(bookDto.getEditorial());
        book.setEnabled(bookDto.isEnabled());
        book.setTicket(bookDto.getTicket());
        book.setTitle(title);

        bookRepository.save(book);
        return new SuccessfullyMessageDto("El Libro se creó correctamente");

    }

    @Override
    public BookDto getById(Long id) {
        Book book = bookRepository.findById(id).get();
        return new BookDto(
                book.getEdition(),
                book.getYear(),
                book.getEditorial(),
                book.getTitle(),
                book.isEnabled(),
                book.getTicket()
        );
    }

    @Override
    public void update(Long id, BookDto object) {

    }

    @Override
    public SuccessfullyMessageDto deleteById(Long id) {
        bookRepository.deleteById(id);
        return new SuccessfullyMessageDto("El libro id: "+id+" se eliminó correctamente");
    }
}
