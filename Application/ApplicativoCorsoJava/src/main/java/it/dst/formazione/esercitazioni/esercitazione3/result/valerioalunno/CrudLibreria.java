package it.dst.formazione.esercitazioni.esercitazione3.result.valerioalunno;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.esercitazioni.esercitazione3.result.AlfredoCastaldi.ConnectionManager;
import it.dst.formazione.esercitazioni.esercitazione3.result.ronceros.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrudLibreria implements BibliotecaInterface {
    private static Connection connection = ConnectionManager.getConnection();

    @Override
    public String createTableLibro() {
        Integer affectedRows = 0;
        String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";

        try {

            Statement stmt = connection.createStatement();
            affectedRows = stmt.executeUpdate(query);
            // da vedere
            System.out.println(affectedRows > 0 ? "tabella creata" : "la tabella già esiste");
            return "OK";

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
            return "ERROR";
        }

    }

    public Integer veroInserimento(Libro libri) {
        String query = "INSERT INTO libro (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        Integer affectedRows = 0;
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, libri.getTitolo());
            pstmt.setString(2, libri.getAutore());
            pstmt.setInt(3, libri.getAnnoPubblicazione());
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return affectedRows;
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libro (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "Don Cisciotte della Mancia");
            pstmt.setString(2, "Miguel de Cervantes");
            pstmt.setInt(3, 1605);
            pstmt.executeUpdate();
            return "OK";
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
            return "ERROR";
        }


    }

    @Override
    public List<Libro> testSelezione() {
        String query = "SELECT * FROM libro";
        List<Libro> results = new ArrayList<>();
        try (
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {


                results.add(new Libro(
                        rs.getObject("id", Integer.class),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getObject("anno_pubblicazione", Integer.class),
                        rs.getObject("disponibile", Boolean.class))
                );
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dati: " + e.getMessage());
        }
        return results;
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        String query = "SELECT * FROM libri";

        try (Connection conn = DatabaseConnection.getConnection();
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
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, false);
            pstmt.setInt(2, 1);

            System.out.println("Disponibilità aggiornata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'aggiornamento: " + e.getMessage());
        }

        return "";
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, 1);
            pstmt.executeUpdate();

            System.out.println("Libro eliminato con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
        }

        return "";
    }
}
