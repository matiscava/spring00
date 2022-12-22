package com.example.biblioteca.service;

import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.dto.TitleDto;
import com.example.biblioteca.entity.Author;
import com.example.biblioteca.entity.Book;
import com.example.biblioteca.entity.Title;
import com.example.biblioteca.repository.IAuthorRepository;
import com.example.biblioteca.repository.IBookRepository;
import com.example.biblioteca.repository.ITitleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TitleService implements ITitleService{
    private ITitleRepository titleRepository;
    private IBookRepository bookRepository;
    private IAuthorRepository authorRepository;

    public TitleService (ITitleRepository titleRepository, IBookRepository bookRepository, IAuthorRepository authorRepository) {
        this.titleRepository = titleRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<TitleDto> getAll() {
        List<Title> titleList = titleRepository.findAll();
        List<TitleDto> titleDtoList = titleList.stream().map(
                title -> {
                    return new TitleDto(
                            title.getTitle(),
                            title.getBookList(),
                            title.getAuthors()
                    );
                }
        ).collect(Collectors.toList());
        return titleDtoList;
    }

    @Override
    public SuccessfullyMessageDto create(TitleDto titleDto) {
        Title title = new Title();
        List<Book> bookList = new ArrayList<>();
        Set<Author> authorSet = new HashSet<>();
        titleDto.getBookList().stream().map(
                book -> {
                    bookList.add(bookRepository.findById(book.getId()).get());
                    return bookList;
                }
        ).collect(Collectors.toList());
        titleDto.getAuthors().stream().map(
                author -> {
                    authorSet.add(authorRepository.findById(author.getId()).get());
                    return authorSet;
                }
        ).collect(Collectors.toList());
        title.setTitle(titleDto.getTitle());
        title.setBookList(bookList);
        title.setAuthors(authorSet);
        titleRepository.save(title);
        return new SuccessfullyMessageDto("El Titulo de libro se creó correctamente");

    }

    @Override
    public TitleDto getById(Long id) {
        Title title = titleRepository.findById(id).get();
        return new TitleDto(
                title.getTitle(),
                title.getBookList(),
                title.getAuthors()
        );
    }

    @Override
    public void update(Long id, TitleDto object) {

    }

    @Override
    public SuccessfullyMessageDto deleteById(Long id) {
        titleRepository.deleteById(id);
        return new SuccessfullyMessageDto("El Título id: "+id+" se eliminó correctamente");
    }
}
