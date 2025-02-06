package it.dst.formazione.esercitazioni.esercitazione3.result;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.tools.InputOuyputConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDbibliotecaGL implements BibliotecaInterface {

    // Costanti per la connessione al database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "03571590!Massi";

    // Costanti per le query SQL
    private static final String INSERT_QUERY = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM libri";
    private static final String SELECT_BY_DISPONIBILITA = "SELECT * FROM libri WHERE disponibile = ?";
    private static final String UPDATE_DISPONIBILITA = "UPDATE libri SET disponibile = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM libri WHERE id = ?";

    // Metodo per creare la tabella
    @Override
    public String createTableLibro() {
        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(InputOuyputConst.query);
            return InputOuyputConst.resultString;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Errore nella creazione della tabella: " + e.getMessage();
        }
    }

    // Metodo per inserire i libri predefiniti
    @Override
    public String testInserimento() {
        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)) {

            for (Libro libro : InputOuyputConst.libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
            }

            return InputOuyputConst.resultString;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Errore nell'inserimento dei libri: " + e.getMessage();
        }
    }

    // Nuovo metodo per inserimento manuale di un libro
    public String inserisciLibroManualmente(String titolo, String autore, int annoPubblicazione, boolean disponibile) {
        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            // Validazione
            if (titolo == null || titolo.trim().isEmpty()) {
                return "Errore: il titolo non può essere vuoto";
            }
            if (autore == null || autore.trim().isEmpty()) {
                return "Errore: l'autore non può essere vuoto";
            }
            if (annoPubblicazione <= 0) {
                return "Errore: anno di pubblicazione non valido";
            }

            pstmt.setString(1, titolo);
            pstmt.setString(2, autore);
            pstmt.setInt(3, annoPubblicazione);
            pstmt.setBoolean(4, disponibile);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    return "OK - Libro inserito con ID: " + id;
                }
            }

            return InputOuyputConst.resultString;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Errore nell'inserimento del libro: " + e.getMessage();
        }
    }

    // Metodi per la selezione
    @Override
    public List<Libro> testSelezione() {
        List<Libro> libri = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY)) {

            while (rs.next()) {
                libri.add(createLibroFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libri;
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        List<Libro> libri = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_DISPONIBILITA)) {

            pstmt.setBoolean(1, disponibile);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                libri.add(createLibroFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libri;
    }


    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_DISPONIBILITA)) {

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            pstmt.executeUpdate();

            return InputOuyputConst.resultString;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Errore nell'aggiornamento della disponibilità: " + e.getMessage();
        }
    }

    @Override
    public String testEliminazione(int idLibro) {
        try (Connection conn = DriverManager.getConnection(InputOuyputConst.URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, idLibro);
            pstmt.executeUpdate();

            return InputOuyputConst.resultString;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Errore nell'eliminazione del libro: " + e.getMessage();
        }
    }

    // Metodo di utilità
    private Libro createLibroFromResultSet(ResultSet rs) throws SQLException {
        return new Libro(
                rs.getInt("id"),
                rs.getString("titolo"),
                rs.getString("autore"),
                rs.getInt("anno_pubblicazione"),
                rs.getBoolean("disponibile")
        );
    }
}