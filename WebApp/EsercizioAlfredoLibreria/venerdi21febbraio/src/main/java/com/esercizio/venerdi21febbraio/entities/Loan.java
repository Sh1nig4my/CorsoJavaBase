package com.esercizio.venerdi21febbraio.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laons")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "data_prestito", nullable = false)
    private Date dataPrestito;
    @Column(name = "data_restituzione")
    private Date dataRestituzione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}
