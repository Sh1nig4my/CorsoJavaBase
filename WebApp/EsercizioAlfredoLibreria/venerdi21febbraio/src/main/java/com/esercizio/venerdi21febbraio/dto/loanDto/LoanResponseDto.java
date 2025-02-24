package com.esercizio.venerdi21febbraio.dto.loanDto;

import com.esercizio.venerdi21febbraio.dto.bookDto.BookResponseDto;
import com.esercizio.venerdi21febbraio.dto.userDto.UserBaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDto {

    private Date dataPrestito;
    private Date dataRestituzione;

    private UserBaseResponseDto userBaseResponseDto;

    private BookResponseDto bookResponseDto;
}
