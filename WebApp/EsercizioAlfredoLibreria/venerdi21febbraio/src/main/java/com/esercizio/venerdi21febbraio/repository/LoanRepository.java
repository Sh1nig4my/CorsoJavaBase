package com.esercizio.venerdi21febbraio.repository;

import com.esercizio.venerdi21febbraio.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface LoanRepository extends JpaRepository<Loan, BigInteger> {


}
