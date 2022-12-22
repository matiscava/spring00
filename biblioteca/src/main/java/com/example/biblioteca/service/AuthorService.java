package com.example.biblioteca.service;

import com.example.biblioteca.dto.AuthorDto;
import com.example.biblioteca.dto.SuccessfullyMessageDto;
import com.example.biblioteca.entity.Author;
import com.example.biblioteca.entity.Title;
import com.example.biblioteca.repository.IAuthorRepository;
import com.example.biblioteca.repository.ITitleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IAuthorService{
    private IAuthorRepository authorRepository;
    private ITitleRepository titleRepository;

    public AuthorService(IAuthorRepository authorRepository, ITitleRepository titleRepository){
        this.authorRepository = authorRepository;
        this.titleRepository = titleRepository;
    }

    @Override
    public List<AuthorDto> getAll() {
        Object mapper = new ObjectMapper();
        List<Author> authorList = authorRepository.findAll();
        List<AuthorDto> authorDtoList = authorList.stream().map(
                author -> {
                    return new AuthorDto(
                            author.getName(),
                            author.getLastname(),
                            author.getBorn_date(),
                            author.getDeath_date(),
                            author.getInfo(),
                            author.getTitleList()
                    );
                }
        ).collect(Collectors.toList());
        return authorDtoList;
    }

    @Override
    public SuccessfullyMessageDto create(AuthorDto authorDto) {
        Author author = new Author();
        Set<Title> titleList = new HashSet<>();
        authorDto.getTitleList().stream().map(
                title -> {
                    titleList.add(titleRepository.findById(title.getId()).get());
                    return titleList;
                }
        ).collect(Collectors.toList());

        author.setName(authorDto.getName());
        author.setLastname(authorDto.getLastname());
        author.setBorn_date(authorDto.getBorn_date());
        author.setDeath_date(authorDto.getDeath_date());
        author.setInfo(authorDto.getInfo());
        author.setTitleList(titleList);
        authorRepository.save(author);
        return new SuccessfullyMessageDto("El autor se creó correctamente.");

    }

    @Override
    public AuthorDto getById(Long id) {
        Author author = authorRepository.findById(id).get();
        return new AuthorDto(
                author.getName(),
                author.getLastname(),
                author.getBorn_date(),
                author.getDeath_date(),
                author.getInfo(),
                author.getTitleList()
        );
    }

    @Override
    public void update(Long id, AuthorDto object) {

    }

    @Override
    public SuccessfullyMessageDto deleteById(Long id) {
        authorRepository.deleteById(id);
        return new SuccessfullyMessageDto("El autor id: "+id+" se eliminó correctamente");
    }
}
