package com.esercizio.venerdi21febbraio.controller;

import com.esercizio.venerdi21febbraio.dto.bookDto.BookRegisterDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.BookResponseDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.DtoMapperBook;
import com.esercizio.venerdi21febbraio.dto.userDto.UserBaseResponseDto;
import com.esercizio.venerdi21febbraio.dto.userDto.UserRegisterDto;
import com.esercizio.venerdi21febbraio.entities.Book;
import com.esercizio.venerdi21febbraio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/libri")
public class BookController {


    @Autowired
    BookService bookService;

    //CREATE
    @PostMapping
    public ResponseEntity<BookResponseDto> postBook(@RequestBody BookRegisterDto dto){
        Optional<BookResponseDto> opt = bookService.createBook(dto);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    //READ
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> findBookById(@PathVariable BigInteger id){
        return bookService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getALlUser(){
        return ResponseEntity.ok(bookService.findAll());
    }

    //UPDATE
    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> updateOneBook(@RequestBody BookRegisterDto registerDto, @PathVariable BigInteger bookId){
       return  bookService.updateOneBook(registerDto, bookId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()) ;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable BigInteger id){
       bookService.deleteBookById(id);
    }
}
