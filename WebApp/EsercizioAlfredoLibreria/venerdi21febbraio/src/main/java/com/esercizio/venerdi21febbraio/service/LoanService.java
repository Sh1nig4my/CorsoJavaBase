package com.esercizio.venerdi21febbraio.service;

import com.esercizio.venerdi21febbraio.dto.loanDto.DtoMapperLoan;
import com.esercizio.venerdi21febbraio.dto.loanDto.LoanRegisterDto;
import com.esercizio.venerdi21febbraio.dto.loanDto.LoanResponseDto;
import com.esercizio.venerdi21febbraio.entities.Book;
import com.esercizio.venerdi21febbraio.entities.Loan;
import com.esercizio.venerdi21febbraio.repository.BookRepository;
import com.esercizio.venerdi21febbraio.repository.LoanRepository;
import com.esercizio.venerdi21febbraio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    DtoMapperLoan dtoMapperLoan;


    //CREATE
    public Optional<LoanResponseDto> newLoan(LoanRegisterDto dto) {
        try {
            Book book = bookRepository.findById(dto.getBookId()).get();
            book.setDisponibile(false);
            Loan newLoan = dtoMapperLoan.fromDtoRegisterToEntity(dto);
            return Optional.of(loanRepository.save(newLoan)).map(dtoMapperLoan::fromEntityToDto);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    //READ
    public Optional<LoanResponseDto> findById(BigInteger id) {
        return loanRepository.findById(id).map(dtoMapperLoan::fromEntityToDto);
    }

    public List<LoanResponseDto> findAllLoans() {
        return loanRepository.findAll().stream().map(dtoMapperLoan::fromEntityToDto).toList();
    }

    //UPDATE
    public Optional<LoanResponseDto> restituzioneLoan(BigInteger id, Date dataRestituzione) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            optionalLoan.get().setDataRestituzione(dataRestituzione);
            optionalLoan.get().getBook().setDisponibile(true);
            loanRepository.save(optionalLoan.get());
            return optionalLoan.map(dtoMapperLoan::fromEntityToDto);
        }
        return Optional.empty();
    }

    //DELETE
    public Boolean deleteLoan(BigInteger id) {
        Optional<Loan> recordToDelete = loanRepository.findById(id);
        if (recordToDelete.isPresent()) {
            loanRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
