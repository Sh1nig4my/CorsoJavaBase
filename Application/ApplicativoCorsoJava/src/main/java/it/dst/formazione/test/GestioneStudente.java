package it.dst.formazione.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GestioneStudente {

    // Metodo per aggiungere un nuovo studente
    void aggiungiStudente() throws Exception;

    // Metodo per elencare tutti gli studenti
    List<Studente> elencoStudenti();

    // Metodo per ricercare uno studente per email
    Optional<Studente> trovaStudentePerEmail(String email) throws SQLException;

    // Metodo per creare la tabella studenti nel database se non esiste
    void creaTabellaStudenti();

    // Metodo per connettersi al database
    Connection connessioneDatabase() throws SQLException;

    // Metodo per chiudere la connessione al database
    void chiudiConnessione();

}
