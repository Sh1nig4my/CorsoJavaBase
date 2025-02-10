package it.dst.formazione.esercitazioni.esercitazione3;


import it.dst.formazione.tools.InputOutputConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static it.dst.formazione.tools.InputOutputConst.*;

public class CRUDBiblioteca implements BibliotecaInterface{

    private static final String USER = "root";
    private static final String PASSWORD = "011092";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";

        List<Libro> libri = InputOutputConst.libri;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            int count = 0;
            for (Libro libro : libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
                count++;
            }

            System.out.println("[Test Inserimento] OK - Righe inserite: " + count);

        } catch (SQLException e) {
            System.err.println("[Test Inserimento] ERRORE - " + e.getMessage());
            throw new RuntimeException(e);
        }

        return resultString;
    }

    @Override
    public List<Libro> testSelezione() {
        String query = "SELECT * FROM libri";
        List<Libro> libri = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getInt("anno_pubblicazione"),
                        rs.getBoolean("disponibile")
                );
                libri.add(libro);
            }

        } catch (SQLException e) {
            System.err.println("[Test Selezione] ERRORE - " + e.getMessage());
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        List<Libro> libri = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, disponibile);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getInt("anno_pubblicazione"),
                        rs.getBoolean("disponibile")
                );
                libri.add(libro);
            }

        } catch (SQLException e) {
            System.err.println("[Test Selezione Filtrata] ERRORE - " + e.getMessage());
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("\n[Test Aggiornamento] OK - Righe aggiornate: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("[Test Aggiornamento] ERRORE - " + e.getMessage());
            throw new RuntimeException(e);
        }

        return resultString;
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idLibro);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("\n[Test Eliminazione] OK - Righe eliminate: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("[Test Eliminazione] ERRORE - " + e.getMessage());
            throw new RuntimeException(e);
        }

        return resultString;
    }

    @Override
    public String createTableLibro() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }

        return resultString;
    }


}
