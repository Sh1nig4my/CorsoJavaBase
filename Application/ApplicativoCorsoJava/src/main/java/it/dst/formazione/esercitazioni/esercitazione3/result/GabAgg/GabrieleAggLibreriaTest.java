package it.dst.formazione.esercitazioni.esercitazione3.result.GabAgg;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.tools.InputOutputConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GabrieleAggLibreriaTest implements BibliotecaInterface {

    //Migliorato catch (Gabriele 6/2/25, 12.50)

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String OKSTATO = "OK";


    @SuppressWarnings("unused")
    public static void testConnessione() throws SQLException{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){

            System.out.println("Connessione al db riuscita");

        } catch (SQLException e){
            System.out.println("Errore nella connessione al database.");
            System.out.println("Codice dell'errore: " + e.getErrorCode());
            System.out.println("Messaggio dell'errore: " + e.getMessage());
            System.out.println("StackTrace stampato come array: " + Arrays.toString(e.getStackTrace()));
            System.out.println("Altre info test: " + e.getSQLState());
        }
    }


    public Connection getConnection() throws SQLException{
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }


    @Override
    public String createTableLibro()  {

        // GabrieleAgg 6/2/25 12:57 modificata con query in InputOutputConst.
        String query = InputOutputConst.query;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(query);
            return OKSTATO;

        } catch (SQLException e) {
            return ("Errore nella creazione della tabella: " + e.getMessage());
        }
    }

    @Override
    public String testInserimento() {

        // Emanuele: e se volessi inserire tutti i libri presenti nella lista dell'Interfaccia InputOutputConst??
        // GabrieleA: Metodo a seguire che inserisce la lista presente nell'interfaccia.
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "Il Signore degli Anelli");
            pstmt.setString(2, "J.R.R. Tolkien");
            pstmt.setInt(3, 1954);
            pstmt.executeUpdate();

            return OKSTATO;

        } catch (SQLException e) {
           return ("Errore durante l'inserimento: " + e.getMessage());
        }
    }

    //Nel main di TestBibliotecaGabriele questo è il passaggio 2.5 (creato su richiesta di Emanuele)
    public String testInserimentoLibriDaInputOutputConst() throws SQLException{

        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (Libro libro : InputOutputConst.libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.executeUpdate();
            }
            return OKSTATO;

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


    /*
      Nota di Gabriele: La prima volta che viene eseguito questo metodo e subito dopo la prova di stampa, in console
      apparirà ancora come true, nonostante questo il metodo funziona, penso sia un problema di concorrenza di azioni,
      simile a una data race, dove l'invio di questi dati nel db, risultano più lenti del programma in java.
      Esaminerò la situazione, penso si possa risolvere dando tempo, magari usando uno Sleep per testare la teoria.
     */
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
                return OKSTATO;
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
                return OKSTATO;
            } else {
                return "Nessun libro trovato con id: " + idLibro;
            }

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
            return "Errore nell'eliminazione";
        }
    }

}
