package com.esercizio.venerdi21febbraio.dto.bookDto;

import com.esercizio.venerdi21febbraio.entities.Book;

import java.util.List;

public class DtoMapperBook {

    public static BookResponseDto fromEntityToDto(Book book){
        return BookResponseDto.builder()
                .id(book.getId())
                .anno_pubblicazione(book.getAnno_pubblicazione())
                .titolo(book.getTitolo())
                .autore(book.getAutore())
                .build();
    }

    public static Book fromRegisterDtoToEntity(BookRegisterDto registerDto){
        return Book.builder()
                .anno_pubblicazione(registerDto.getAnno_pubblicazione())
                .titolo(registerDto.getTitolo())
                .autore(registerDto.getAutore())
                .build();
    }

    public static List<BookResponseDto> fromEntityListToDtoList(List<Book> books){
        return books.stream().map(DtoMapperBook::fromEntityToDto).toList();
    }
}
