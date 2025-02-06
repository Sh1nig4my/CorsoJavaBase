package it.dst.formazione.esercitazioni.esercitazione3.result;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static it.dst.formazione.lezioni.lezione13.JDBCConnection.getConnection;
//import static it.dst.formazione.tools.InputOuyputConst.libri;

public class CRUDBibliotecaFrancescoCalabro implements BibliotecaInterface {

    // TODO: potrebbe essere una soluzione la cattura di una ecceione specifica per SQL e propagare l'errore? Parlo per tutti i metodi


    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "Kenpachi92#";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String createTableLibro() {
        // TODO: la query la puoi prendere dall'interfaccia inputOutputConst
        String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) { // INFO: secondo te come mai questo warning?

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }
        return ""; // TODO: la stringa la puoi prendere dall'interfaccia inputOutputConst
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
        // TODO: la list la puoi prendere dall'interfaccia inputOutputConst
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

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: secondo te come mai questo warning?

            for (Libro libro : libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
            }
//            pstmt.setString(1, "Il Signore degli Anelli");
//            pstmt.setString(2, "J.R.R. Tolkien");
//            pstmt.setInt(3, 1954);
//            pstmt.executeUpdate();
            System.out.println("Libro inserito con successo.");
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return ""; // TODO: la stringa la puoi prendere dall'interfaccia inputOutputConst
    }

    @Override
    public List<Libro> testSelezione() {
        String query = "SELECT * FROM libri";
        List<Libro> libri = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query); // INFO: secondo te come mai questo warning?
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id"); // INFO: non utilizzi questo id
                String titolo = rs.getString("titolo");
                String autore = rs.getString("autore");
                int annoPubblicazione = rs.getInt("anno_pubblicazione");
                boolean disponibile = rs.getBoolean("disponibile");
                libri.add(new Libro(titolo, autore, annoPubblicazione, disponibile));
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei dati: " + e.getMessage());
        }
        return libri;
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        List<Libro> libriFiltrati = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: secondo te come mai questo warning?

            pstmt.setBoolean(1, disponibile);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id"); // INFO: idem sopra
                    String titolo = rs.getString("titolo");
                    String autore = rs.getString("autore");
                    int annoPubblicazione = rs.getInt("anno_pubblicazione");
                    boolean disponibileLibri = rs.getBoolean("disponibile");
                    libriFiltrati.add(new Libro(titolo, autore, annoPubblicazione, disponibileLibri));
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dati: " + e.getMessage());
        }
        return libriFiltrati;
    }


    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: secondo te come mai questo warning?

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            pstmt.executeUpdate();
            System.out.println("Disponibilità aggiornata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'aggiornamento: " + e.getMessage());
        }
        return ""; // TODO: la stringa la puoi prendere dall'interfaccia inputOutputConst
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: secondo te come mai questo warning?

            pstmt.setInt(1, 1);
            pstmt.executeUpdate();
            System.out.println("Libro eliminato con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
        }
        return ""; // TODO: la stringa la puoi prendere dall'interfaccia inputOutputConst
    }

}




