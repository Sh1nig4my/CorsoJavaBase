package it.dst.formazione.esercitazioni.esercitazione3.result.DarioFlavioScipioni;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrudLibreria implements BibliotecaInterface {
    public static Connection connection = ConnessioneDatabase.getConnection();

    @Override
    public String createTableLibro() {
        String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";

        try (Connection conn = ConnessioneDatabase.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }
        return "";
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
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

        try (Connection conn = ConnessioneDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (Libro libro : libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
            }

            /*pstmt.setString(1, "Il signore degli anelli");
            pstmt.setString(2, "J.R.R. Tolkien");
            pstmt.setInt(3, 1954);
            pstmt.executeUpdate();*/

            System.out.println("Libri inseriti con successo.");

        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return "";
    }

    @Override
    public List<Libro> testSelezione() {
        String query = "SELECT * FROM libri";

        try (Connection conn = ConnessioneDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Titolo: " + rs.getString("titolo") +
                        ", Autore: " + rs.getString("autore") +
                        ", Anno: " + rs.getInt("anno_pubblicazione") +
                        ", Disponibile: " + rs.getBoolean("disponibile"));
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dati: " + e.getMessage());
        }
        return List.of();
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        List<Libro> libriDisponibili = new ArrayList<>();
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        try (Connection conn = ConnessioneDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, disponibile);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Libro libro = new Libro(
                            rs.getInt("id"),
                            rs.getString("titolo"),
                            rs.getString("autore"),
                            rs.getInt("anno_pubblicazione"),
                            rs.getBoolean("disponibile")
                    );
                    libriDisponibili.add(libro);
                }
            }

            } catch (SQLException e) {
                System.err.println("Errore durante la selezione dei libri: " + e.getMessage());
            }

            return libriDisponibili;

        }

        @Override
        public String testAggiornamentoDisponibilita ( int idLibro, boolean disponibile){
            String query = "DELETE FROM libri WHERE id = ?";

            try (Connection conn = ConnessioneDatabase.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

               pstmt.setInt(1, 2);
                pstmt.executeUpdate();

                System.out.println("Libro eliminato con successo.");

            } catch (SQLException e) {
                System.err.println("Errore nell'eliminazione: " + e.getMessage());
            }
            return "";
        }

        @Override
        public String testEliminazione ( int idLibro){
            String query = "DELETE FROM libri WHERE id = ?";

            try (Connection conn = ConnessioneDatabase.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

               pstmt.setInt(1, idLibro);
                pstmt.executeUpdate();

                System.out.println("Libro eliminato con successo.");

            } catch (SQLException e) {
                System.err.println("Errore nell'eliminazione: " + e.getMessage());
            }
            return "";
        }
    }
