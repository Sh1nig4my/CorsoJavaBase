package it.dst.formazione.esercitazioni.esercitazione3.result.nicholasporta;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static it.dst.formazione.tools.InputOutputConst.*;

public class CRUDbibliotecaNicholasPorta implements BibliotecaInterface {

    // TODO: potrebbe essere una soluzione la cattura di una ecceione specifica per SQL e propagare l'errore? Parlo per tutti i metodi

    private static final String USER = "root";
    private static final String PASSWORD = "011092"; //"bnck028360";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }


    public String createTableLibro() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) { // INFO: il warning può essere 'aggiustato'?
            stmt.executeUpdate(query);
            return resultString;
        } catch (SQLException e) {
            return "Errore nella creazione della tabella: " + e.getMessage();
        }
    }

    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: il warning può essere 'aggiustato'?
            for (Libro libro : libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
            }
            return resultString;

        } catch (SQLException e) {
            return "Errore durante l'inserimento: " + e.getMessage();
        }
    }


    public List<Libro> testSelezione() {
        List<Libro> elencoLibri = new ArrayList<>();
        String query = "SELECT * FROM libri";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement(); // INFO: il warning può essere 'aggiustato'?
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                elencoLibri.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getInt("anno_pubblicazione"),
                        rs.getBoolean("disponibile")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Errore nella selezione dei libri: " + e.getMessage());
        }
        return elencoLibri;
    }

    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        List<Libro> elencoLibri = new ArrayList<>();
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: il warning può essere 'aggiustato'?
            pstmt.setBoolean(1, disponibile);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                elencoLibri.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getInt("anno_pubblicazione"),
                        rs.getBoolean("disponibile")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Errore nella selezione filtrata: " + e.getMessage());
        }
        return elencoLibri;
    }

    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: il warning può essere 'aggiustato'?
            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            return resultString;
        } catch (SQLException e) {
            return "Errore nell'aggiornamento della disponibilità: " + e.getMessage();
        }
    }

    public String testEliminazione(int i) {
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // INFO: il warning può essere 'aggiustato'?

            pstmt.setInt(1, 1);
            pstmt.executeUpdate();

            return resultString;

        } catch (SQLException e) {
            return "Errore nell'eliminazione: " + e.getMessage();
        }
    }

    // INFO: molto bene Nicholas!

}







