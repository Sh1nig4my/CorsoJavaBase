package com.esercizio.venerdi21febbraio.dto.loanDto;

import com.esercizio.venerdi21febbraio.dto.bookDto.DtoMapperBook;
import com.esercizio.venerdi21febbraio.dto.userDto.DtoMapperUser;
import com.esercizio.venerdi21febbraio.entities.Book;
import com.esercizio.venerdi21febbraio.entities.Loan;
import com.esercizio.venerdi21febbraio.repository.BookRepository;
import com.esercizio.venerdi21febbraio.repository.UserRepository;
import com.esercizio.venerdi21febbraio.service.BookService;
import com.esercizio.venerdi21febbraio.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Component
public class DtoMapperLoan {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  BookRepository bookRepository;

    public  Loan fromDtoRegisterToEntity(LoanRegisterDto dto) throws SQLException {
        return Loan.builder()
                .dataPrestito(dto.getDataPrestito())
                .user(userRepository.findById(dto.getUserId()).orElseThrow(SQLException::new))
                .book(bookRepository.findById(dto.getBookId())
                .orElseThrow(SQLException::new))
                .build();
    }

    public LoanRestituzioneResponseDto fromEntityToRestituzioneDto(Loan loan, Date dataRestituzione){

        return LoanRestituzioneResponseDto.builder()
                .dataRestituzione(dataRestituzione)
                .userBaseResponseDto(DtoMapperUser.fromEntityToDto(loan.getUser()))
                .bookResponseDto(DtoMapperBook.fromEntityToDto(loan.getBook()))
                .build();
    }

    public  LoanResponseDto fromEntityToDto(Loan loan){
        return LoanResponseDto.builder()
                .userBaseResponseDto(DtoMapperUser.fromEntityToDto(loan.getUser()))
                .bookResponseDto(DtoMapperBook.fromEntityToDto(loan.getBook()))
                .dataRestituzione(loan.getDataRestituzione())
                .dataPrestito(loan.getDataPrestito())
                .build();
    }

    public  List<LoanResponseDto> fromListEntitiesToDtoList(List<Loan> loans){
        return loans.stream().map(this::fromEntityToDto).toList();
    }
}
