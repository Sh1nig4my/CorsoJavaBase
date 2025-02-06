package it.dst.formazione.esercitazioni.esercitazione3.result.francescocalabro;
import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static it.dst.formazione.tools.InputOutputConst.*;

public class CRUDBibliotecaFrancescoCalabro implements BibliotecaInterface {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "Kenpachi92#";

    public static Connection getConnection() throws SQLException{
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String createTableLibro() {

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) { // INFO: secondo te come mai questo warning?

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
            throw new RuntimeException();
        }
        return resultString;
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
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
            throw new RuntimeException();
        }
        return resultString;
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
            throw new RuntimeException();
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
            throw new RuntimeException();
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
            throw new RuntimeException();
        }
        return resultString;
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
            throw new RuntimeException();
        }
        return resultString;
    }

}




