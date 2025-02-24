package com.esercizio.venerdi21febbraio.dto.bookDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private BigInteger id;

    private String titolo;

    private String autore;

    private Date anno_pubblicazione;
}
