package com.esercizio.venerdi21febbraio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    // l'attributo name dell'annotation column lo uso per essere sicuro di salvare la tabella con i giusti nomi
    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Loan> loans;



}

