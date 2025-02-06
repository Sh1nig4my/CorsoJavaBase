package it.dst.formazione.esercitazioni.esercitazione3.result.ronceros;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.tools.InputOutputConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDBibliotecaRonceros implements BibliotecaInterface {

    @Override
    public String createTableLibro() {
        // Tentativo di creazione della tabella 'libri' nel database.
        // La query è predefinita nella costante InputOuyputConst.query.
        // Se la creazione va a buon fine, restituisce un messaggio di successo.
        // In caso di errore, restituisce il messaggio di errore generato.
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(InputOutputConst.query);
            return InputOutputConst.resultString;
        } catch (SQLException e) {
            return "Errore nella creazione della tabella: " + e.getMessage();
        }
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            for (Libro libro : InputOutputConst.libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
            }
            return InputOutputConst.resultString;
        } catch (SQLException e) {
            return "Errore durante l'inserimento: " + e.getMessage();
        }
    }

    @Override
    public List<Libro> testSelezione() {
        List<Libro> libri = new ArrayList<>();
        String query = "SELECT * FROM libri";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                libri.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getInt("anno_pubblicazione"),
                        rs.getBoolean("disponibile")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dati: " + e.getMessage());
        }
        return libri;
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        List<Libro> libri = new ArrayList<>();
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, disponibile);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    libri.add(new Libro(
                            rs.getInt("id"),
                            rs.getString("titolo"),
                            rs.getString("autore"),
                            rs.getInt("anno_pubblicazione"),
                            rs.getBoolean("disponibile")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dati filtrato: " + e.getMessage());
        }
        return libri;
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            int rowsUpdated = pstmt.executeUpdate();
            return (rowsUpdated > 0) ? InputOutputConst.resultString : "Nessun libro aggiornato.";
        } catch (SQLException e) {
            return "Errore nell'aggiornamento: " + e.getMessage();
        }
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLibro);
            int rowsDeleted = pstmt.executeUpdate();
            return (rowsDeleted > 0) ? InputOutputConst.resultString : "Nessun libro eliminato.";
        } catch (SQLException e) {
            return "Errore nell'eliminazione: " + e.getMessage();
        }
    }
}
