package com.esercizio.venerdi21febbraio.controller;

import com.esercizio.venerdi21febbraio.dto.loanDto.LoanRegisterDto;
import com.esercizio.venerdi21febbraio.dto.loanDto.LoanResponseDto;
import com.esercizio.venerdi21febbraio.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService service;

    // CREATE
    @PostMapping
    public ResponseEntity<LoanResponseDto> createLoan(@RequestBody LoanRegisterDto loanDto){
        return service.newLoan(loanDto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    // READ
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> getLoanById(@PathVariable BigInteger id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDto> updateLoanRestituzione(@PathVariable BigInteger id, @RequestParam("date")
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return service.restituzioneLoan(id, date).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable BigInteger id){
        Boolean isRecordDeleted = service.deleteLoan(id);
        if (isRecordDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
