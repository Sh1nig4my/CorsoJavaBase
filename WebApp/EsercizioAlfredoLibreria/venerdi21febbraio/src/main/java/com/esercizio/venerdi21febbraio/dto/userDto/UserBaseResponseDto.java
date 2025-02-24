package com.esercizio.venerdi21febbraio.dto.userDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseResponseDto {

    private BigInteger id;

    private String nome;

    private String email;
}
