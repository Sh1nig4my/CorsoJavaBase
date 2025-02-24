package com.esercizio.venerdi21febbraio.dto.loanDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRegisterDto {

    private Date dataPrestito;

    private BigInteger userId;

    private BigInteger bookId;
}
