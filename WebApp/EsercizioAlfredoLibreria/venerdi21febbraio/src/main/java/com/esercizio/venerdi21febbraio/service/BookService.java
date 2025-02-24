package com.esercizio.venerdi21febbraio.service;

import com.esercizio.venerdi21febbraio.dto.bookDto.BookRegisterDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.BookResponseDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.DtoMapperBook;
import com.esercizio.venerdi21febbraio.dto.userDto.DtoMapperUser;
import com.esercizio.venerdi21febbraio.dto.userDto.UserBaseResponseDto;
import com.esercizio.venerdi21febbraio.entities.Book;
import com.esercizio.venerdi21febbraio.entities.Users;
import com.esercizio.venerdi21febbraio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    //CREATE
    public Optional<BookResponseDto> createBook(BookRegisterDto registerDto){
        Book newBook = DtoMapperBook.fromRegisterDtoToEntity(registerDto);
        newBook.setDisponibile(true);
        Optional<Book> userResponse = Optional.of(bookRepository.save(newBook));
        return userResponse.map(DtoMapperBook::fromEntityToDto);
    }

    //READ
    public Optional<BookResponseDto> findById(BigInteger id) {
        return bookRepository.findById(id).map(DtoMapperBook::fromEntityToDto);
    }

    public List<BookResponseDto> findAll(){
        return DtoMapperBook.fromEntityListToDtoList(bookRepository.findAll());
    }

    //UPDATE
    public Optional<BookResponseDto> updateOneBook(BookRegisterDto registerDto, BigInteger bookId){
        Optional<Book> book =  bookRepository.findById(bookId);
        if (book.isPresent()){
            Book newBook = book.map((value)->{
                value.setAutore(registerDto.getAutore());
                value.setTitolo(registerDto.getTitolo());
                value.setAnno_pubblicazione(registerDto.getAnno_pubblicazione());
                value.setDisponibile(true);
                return value;
            }).get();
            bookRepository.save(newBook);
            return Optional.ofNullable(DtoMapperBook.fromEntityToDto(newBook));
        }
        return Optional.empty();
    }

    // DELETE
    public void deleteBookById(BigInteger id){
        bookRepository.deleteById(id);
    }
}
