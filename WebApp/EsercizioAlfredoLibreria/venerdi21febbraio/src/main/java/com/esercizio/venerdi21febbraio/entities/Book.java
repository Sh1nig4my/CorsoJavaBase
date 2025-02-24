package com.esercizio.venerdi21febbraio.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    // l'attributo name dell'annotation column lo uso per essere sicuro di salvare la tabella con i giusti nomi
    @Column(nullable = false, name = "titolo")
    private String titolo;

    @Column(nullable = false, name = "autore" )
    private String autore;

    @Column(nullable = false, name = "annoPubblicazione")
    private Date anno_pubblicazione;
    // column definition mi fa in modo che sia true se viene inserito non tramite il service
    // non so se è una buona prassi
    @Column(columnDefinition = "boolean default true", name = "disponibile", nullable = false)
    private Boolean disponibile;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Loan> loans;
}

