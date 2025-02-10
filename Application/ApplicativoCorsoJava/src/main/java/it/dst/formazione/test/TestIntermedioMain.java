package it.dst.formazione.test;

import it.dst.formazione.test.TestIntermedio.src.test.java.Connessione.GestioneStudenteV2;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestIntermedioMain {

    public static void main(String[] args) throws Exception {


        GestioneStudenteV2 gestioneStudenti = new GestioneStudenteV2();

        // Connessione al database

        //.0gestioneStudenti.connessioneDatabase();

        // Creazione della tabella studenti
        //gestioneStudenti.creaTabellaStudenti();

        // Aggiunta di alcuni studenti
        try {
            gestioneStudenti.aggiungiStudente();
        } catch (Exception e) {
            System.out.println("Email Duplicta!!" + e.getMessage());
        }

        //gestioneStudenti.aggiungiStudente();

        // Elenco di tutti gli studenti
        List<Studente> studenti = gestioneStudenti.elencoStudenti();
        studenti.forEach(System.out::println);

        // Ricerca di uno studente per email
        //Optional<Studente> studente = gestioneStudenti.trovaStudentePerEmail("marcy9ignite@libero.it");
        //studente.ifPresent(System.out::println);

        // Chiusura connessione
        //gestioneStudenti.chiudiConnessione();
    }

}
