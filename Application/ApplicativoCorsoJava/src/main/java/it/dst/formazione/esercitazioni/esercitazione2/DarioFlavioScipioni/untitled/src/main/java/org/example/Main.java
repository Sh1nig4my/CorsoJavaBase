package org.example;

import org.example.ambientazione.Corridoio;
import org.example.ambientazione.Scenario;
import org.example.eventi.Eventi;
import org.example.giocatore.Persona;
import org.example.giocatore.Ruolo;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        LocalDateTime inizio = LocalDateTime.now();

        Persona.creaPersonaggio();
        Ruolo.scegliRuolo();
        Scenario.scegliPercorso();

        LocalDateTime fine = LocalDateTime.now();
        long durata = java.time.Duration.between(inizio, fine).getSeconds();
        System.out.println("Tempo di gioco: " + durata + " secondi.");
    }
}
