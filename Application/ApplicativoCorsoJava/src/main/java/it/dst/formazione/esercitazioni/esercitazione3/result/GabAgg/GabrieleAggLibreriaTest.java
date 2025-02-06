package it.dst.formazione.esercitazioni.esercitazione3.result.GabAgg;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GabrieleAggLibreriaTest implements BibliotecaInterface {

    // TODO: potrebbe valere la pena pensare di lanciare un messaggio di Errore nelle sezioni catch?

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";


    public static void testConnessione(){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){

            System.out.println("Connessione al db riuscita");

        } catch (SQLException e){
            System.out.println("Errore nella connessione al database.");
            e.printStackTrace();
        }
    }


    public Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }


    @Override
    public String createTableLibro() {

        // TODO: hai già la query salvata nell'interfaccia InputOutputConst
        String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(query);
            return ("OK");  // TODO: modificre con const

        } catch (SQLException e) {
            return ("Errore nella creazione della tabella: " + e.getMessage());
        }
    }

    @Override
    public String testInserimento() {

        // TODO: e se volessi inserire tutti i libri presnti nella lista dell'Interfaccia InputOutpuConst??
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "Il Signore degli Anelli");
            pstmt.setString(2, "J.R.R. Tolkien");
            pstmt.setInt(3, 1954);
            pstmt.executeUpdate();

            return ("OK"); // TODO: modificre con const

        } catch (SQLException e) {
           return ("Errore durante l'inserimento: " + e.getMessage());
        }
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
            System.err.println("Errore durante il recupero dati: " + e.getMessage());
        }

        return libri;
    }


    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        List<Libro> libriDisponibili = new ArrayList<>();

        try (Connection conn = getConnection();
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
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Disponibilità aggiornata con successo, id libro: " + idLibro);
                return "OK"; // TODO: modificare con const
            } else {
                return "Nessun libro trovato con id: " + idLibro;
            }

        } catch (SQLException e) {
            System.err.println("Errore nell'aggiornamento: " + e.getMessage());
            return "Errore nell'aggiornamento";
        }
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idLibro);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Libro con id: " + idLibro + " eliminato con successo.");
                return "OK"; // TODO: modificre con const
            } else {
                return "Nessun libro trovato con id: " + idLibro;
            }

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
            return "Errore nell'eliminazione";
        }
    }

}
