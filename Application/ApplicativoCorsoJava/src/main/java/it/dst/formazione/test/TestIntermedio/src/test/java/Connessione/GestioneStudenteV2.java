package it.dst.formazione.test.TestIntermedio.src.test.java.Connessione;

import it.dst.formazione.test.GestioneStudente;
import it.dst.formazione.test.Studente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestioneStudenteV2 implements GestioneStudente {

    List<Studente> studenteList = new ArrayList<>();

    @Override
    public void aggiungiStudente() throws Exception {

        Studente studenteNEw= new Studente("Mario", "Rossi", "mariorossi@email.it");
        Integer counter = findMultiplibyEmail(studenteNEw.getEmail());

        if (counter == 0) {
            studenteList.add(studenteNEw);
        } else {
            throw new Exception("Email già presente!!!");
        }
    }

    @Override
    public List<Studente> elencoStudenti() {

        studenteList.forEach(System.out::println);
        return studenteList;
    }

    private Integer findMultiplibyEmail(String email) {

        Integer counter = 0;
        for (Studente studente : studenteList) {
            if (studente.getEmail().equalsIgnoreCase(email)) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public Optional<Studente> trovaStudentePerEmail(String email) throws SQLException {

       for (Studente studente : studenteList) {
            if (studente.getEmail().equalsIgnoreCase(email)) {
                return Optional.of(studente);
            }
        }
        return Optional.empty();
    }

    @Override
    public void creaTabellaStudenti() {

    }

    @Override
    public Connection connessioneDatabase() throws SQLException {
        return null;
    }

    @Override
    public void chiudiConnessione() {

    }
}
