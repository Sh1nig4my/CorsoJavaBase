package it.dst.formazione.tools;

import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.util.Arrays;
import java.util.List;

public interface InputOuyputConst {

    String resultString = "OK";
    String BLANK = " ";

    String query = "CREATE TABLE IF NOT EXISTS libri ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "titolo VARCHAR(100) NOT NULL, "
            + "autore VARCHAR(100) NOT NULL, "
            + "anno_pubblicazione INT NOT NULL, "
            + "disponibile BOOLEAN DEFAULT TRUE)";

    String URL = "jdbc:mysql://localhost:3306/biblioteca";

    List<Libro> libri = Arrays.asList(
            new Libro("I Promessi Sposi", "Alessandro Manzoni", 1827, true),
            new Libro("1984", "George Orwell", 1949, true),
            new Libro("Il Piccolo Principe", "Antoine de Saint-Exupéry", 1943, true),
            new Libro("Harry Potter e la Pietra Filosofale", "J.K. Rowling", 1997, true),
            new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 1954, false),
            new Libro("Il Nome della Rosa", "Umberto Eco", 1980, true),
            new Libro("Orgoglio e Pregiudizio", "Jane Austen", 1813, true),
            new Libro("Delitto e Castigo", "Fëdor Dostoevskij", 1866, true),
            new Libro("Il Processo", "Franz Kafka", 1925, true),
            new Libro("Moby Dick", "Herman Melville", 1851, true)
    );

}
