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
        Scanner scanner = new Scanner(System.in);
        Persona personaggio = new Persona();
        System.out.println("Benvenuto in Cosmic Impact!\nCome ti chiami.\nInserisci nome: ");
        LocalDateTime inizio = LocalDateTime.now();
        personaggio.setNome(scanner.nextLine());
        System.out.println("Benvenuto comandante: " + personaggio.getNome());
        System.out.println("Da che pianeta provieni?");
        personaggio.setProvenienza(scanner.nextLine());
        System.out.println("NOME-> " + personaggio.getNome());
        System.out.println("PIANETA DI PROVENIENZA-> " + personaggio.getProvenienza() + "\n");
        System.out.println("La tua navicella dopo aver impattato un asteroide ha attivato il sistema di sicurezza che prevede l'ibernazione dell'equipaggio.\nAvete vagato per 3 anni nello spazio, ma purtroppo sei l'unico sopravvissuto.\nPer tua fortuna sei approdato in questa stazione spaziale abbadonata.\nBenvenuto a EPSILON 9!\n\nMISSIONE: Trova il modo di riparare la tua nave e tornare sul Pianeta " + personaggio.getProvenienza());

        Ruolo.scegliRuolo();

        System.out.println("Bene " + personaggio.getNome() + " Possiamo iniziare!\n\nSei nella sala principale,buia e cupa, della stazione spaziale.\n\nDavanti a te hai tre percorsi\n");

        Scenario.scegliPercorso();

        LocalDateTime fine = LocalDateTime.now();
        long durata = java.time.Duration.between(inizio, fine).getSeconds();
        System.out.println("Tempo di gioco: " + durata + " secondi.");
    }
}
