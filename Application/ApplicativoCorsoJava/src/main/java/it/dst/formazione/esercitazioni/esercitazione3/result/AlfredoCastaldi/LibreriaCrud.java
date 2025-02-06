package it.dst.formazione.esercitazioni.esercitazione3.result.AlfredoCastaldi;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.tools.InputOutputConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LibreriaCrud implements BibliotecaInterface {

    private static Connection connection = ConnectionManager.getConnection();
    private static String resultString = InputOutputConst.resultString;

    // TODO: per la gestione dell'errore puoi utilizzare una ecdezione? Magari catturando e propagando l'errore catturato..


    @Override
    public String createTableLibro() {
        int affectedRows = 0;
        String query = InputOutputConst.query;
        String tableName = "libri";
        try {
            Statement stmt = connection.createStatement();
            affectedRows = stmt.executeUpdate(query);
            // da vedere
            System.out.println(!checkIfTableExists(connection, tableName) ? "tabella creata" : "la tabella già esiste");
            return resultString;

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
            return "ERROR";
        }

    }

    private Boolean checkIfTableExists(  Connection connection, String tableName) throws SQLException {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});
            return resultSet.next();

    }

    // TODO: perché vero??
    // perchè inserisce sul database un istanza della classe Libro
    public Integer veroInserimento(Libro book) {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        int affectedRows = 0;
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitolo());
            pstmt.setString(2, book.getAutore());
            pstmt.setInt(3, book.getAnnoPubblicazione());
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return affectedRows;
    }


    // TODO: e se volessi inserire tutta la lista libri presente nell'interfaccia InputOutputConst
    // inserimento tutta la lista presa da InputOutputConst.libri
    public int inserimentoInteraLista(){
        List<Libro> libri = InputOutputConst.libri;
        AtomicReference<Integer> affectedRows = new AtomicReference<>(0);
        libri.forEach((libro)->{ affectedRows.updateAndGet(v -> v + veroInserimento(libro));});
        return affectedRows.get();
    }


    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "Il Signore degli Anelli");
            pstmt.setString(2, "J.R.R. Tolkien");
            pstmt.setInt(3, 1954);
            pstmt.executeUpdate();
            return resultString;
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
            return "ERROR";
        }

    }

    @Override
    public List<Libro> testSelezione() {
        String query = "SELECT * FROM libri";
        List<Libro> results = new ArrayList<>();
        try (
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                /*
                 System.out.println("ID: " + rs.getInt("id") +
                        ", Titolo: " + rs.getString("titolo") +
                        ", Autore: " + rs.getString("autore") +
                        ", Anno: " + rs.getInt("anno_pubblicazione") +
                        ", Disponibile: " + rs.getBoolean("disponibile"));
                 */

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
        //TODO: la tua soluzione è buona, può essere più efficiente prevedere una query specifica per questa selezione e non utilizzare un stream?
        // nuova soluzione con query:
        String filterQuery = "SELECT * FROM libri WHERE disponibile = true";
        List<Libro> libriFiltrati = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(filterQuery);
         ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                libriFiltrati.add(new Libro(
                        rs.getObject("id", Integer.class),
                        rs.getString("titolo"),
                        rs.getString("autore"),
                        rs.getObject("anno_pubblicazione", Integer.class),
                        rs.getObject("disponibile", Boolean.class))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
        List<Libro> libri = testSelezione();
        List<Libro> libriFiltrati = libri.stream().filter(
                        (libro) -> {
                            return libro.isDisponibile() == disponibile;
                        })
                .toList();

         */
        return libriFiltrati;
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {

        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";
        int affectedRows = 0;
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("il libro selezionato per UPDATE non esiste");
            }
            System.out.println("libro aggiornato con successo");
            return resultString;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "ERROR";
        }

    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";
        int affectedRows = 0;
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, idLibro);
            affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("il libro selezionato per la DELETE non esiste");
            }
            System.out.println("Libro eliminato con successo.");
            return resultString;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "ERROR";
        }

    }

}