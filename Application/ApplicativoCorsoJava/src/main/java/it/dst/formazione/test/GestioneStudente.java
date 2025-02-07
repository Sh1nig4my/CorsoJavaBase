package it.dst.formazione.test;

import java.util.List;
import java.util.Optional;

public interface GestioneStudente {

    // Metodo per aggiungere un nuovo studente
    void aggiungiStudente(Studente studente);

    // Metodo per elencare tutti gli studenti
    List<Studente> elencoStudenti();

    // Metodo per ricercare uno studente per email
    Optional<Studente> trovaStudentePerEmail(String email);

    // Metodo per creare la tabella studenti nel database se non esiste
    void creaTabellaStudenti();

    // Metodo per connettersi al database
    void connessioneDatabase();

    // Metodo per chiudere la connessione al database
    void chiudiConnessione();

}
