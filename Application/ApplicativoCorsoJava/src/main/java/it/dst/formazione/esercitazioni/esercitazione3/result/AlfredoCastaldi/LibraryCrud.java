package it.dst.formazione.esercitazioni.esercitazione3.result.AlfredoCastaldi;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryCrud implements BibliotecaInterface {

    private static Connection connection = ConnectionManager.getConnection();

    // TODO: per la gestione dell'errore puoi utilizzare una ecdezione? Magari catturando e propagando l'errore catturato..
    // INFO: se provo ad eseguire tutto dal Main si rompe mle, come mai secondo te?
    // INFO: comunque sia l'esercitazione va bene

    @Override
    public String createTableLibro() {
        Integer affectedRows = 0; // TODO: inizializzazione non necessaria
        // TODO: la query la puoi prendere da InputOutputConst
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
            return "OK"; // TODO: la puoi prendere da InputOutputConst

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
            return "ERROR";
        }

    }

    // TODO: perché vero??
    public Integer veroInserimento(Libro book) {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        Integer affectedRows = 0; // TODO: perchè l'ide ci dice di fare un wrap secondo te?
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
    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "Il Signore degli Anelli");
            pstmt.setString(2, "J.R.R. Tolkien");
            pstmt.setInt(3, 1954);
            pstmt.executeUpdate();
            return "OK"; // TODO: la puoi prendere da InputOutputConst
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
        List<Libro> libri = testSelezione();
        List<Libro> libriFiltrati = libri.stream().filter(
                        (libro) -> {
                            return libro.isDisponibile() == disponibile;
                        })
                .toList();
        return libriFiltrati;
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {

        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";
        Integer affectedRows = 0; // TODO: altro warning come sopra
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("errore nell'aggiornamento");
            }
            System.out.println("libro aggiornato con successo");
            return "OK"; // TODO: la puoi prendere da InputOutputConst
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "ERROR";
        }

    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";
        Integer affectedRows = 0; // TODO
        try (
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, idLibro);
            affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("libro non trovato");
            }
            System.out.println("Libro eliminato con successo.");
            return "OK"; // TODO: la puoi prendere da InputOutputConst
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "ERROR";
        }

    }
}
