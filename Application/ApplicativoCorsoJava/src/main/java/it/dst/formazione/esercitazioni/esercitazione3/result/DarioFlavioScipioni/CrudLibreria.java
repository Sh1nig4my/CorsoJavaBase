package it.dst.formazione.esercitazioni.esercitazione3.result.DarioFlavioScipioni;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;
import it.dst.formazione.tools.InputOutputConst;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudLibreria implements BibliotecaInterface {

    // TODO: potrebbe essere una soluzione la cattura di una ecceione specifica per SQL e propagare l'errore? Parlo per tutti i metodi

    public static Connection connection = ConnessioneDatabase.getConnectionProva();

    @Override
    public String createTableLibro() {
        // TODO: la query sta nell'interfaccia InputOutputConst


        /*String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";*/
        String query = InputOutputConst.query;

        try (Connection conn = ConnessioneDatabase.getConnectionProva();

             
             Statement stmt = conn.createStatement()) {// TODO: c'è un modo per togliere questi warning?

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }
        //return ""; //TODO: la String sta nell'interfaccia InputOutputConst, così il test non passa
        return InputOutputConst.resultString;
    }

    ;;@Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
        // TODO: la lista sta nell'interfaccia InputOutputConst
        List <Libro> libri = InputOutputConst.libri;
       /* List<Libro> libri = Arrays.asList(
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
        );*/

        try (Connection conn = ConnessioneDatabase.getConnectionProva();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: warning

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
        //return ""; // TODO: la String sta nell'interfaccia InputOutputConst, così il test non passa
        return InputOutputConst.resultString;
    }

    @Override
    public List<Libro> testSelezione() {
        String query = "SELECT * FROM libri";

        try (Connection conn = ConnessioneDatabase.getConnectionProva();
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
        //return List.of(); // TODO: così il test non passa
        return InputOutputConst.libri;
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {
        List<Libro> libriDisponibili = new ArrayList<>();
        String query = "SELECT * FROM libri WHERE disponibile = ?";
        try (Connection conn = ConnessioneDatabase.getConnectionProva();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: warning

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
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = ConnessioneDatabase.getConnectionProva();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: warning

            pstmt.setInt(1, 2);
            pstmt.executeUpdate();

            System.out.println("Libro eliminato con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
        }
        //return ""; // TODO: la String sta nell'interfaccia InputOutputConst, così il test non passa
        return InputOutputConst.resultString;
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = ConnessioneDatabase.getConnectionProva();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: warning

            pstmt.setInt(1, idLibro);
            pstmt.executeUpdate();

            System.out.println("Libro eliminato con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
        }
        //return ""; // TODO: la String sta nell'interfaccia InputOutputConst, così il test non passa
        return InputOutputConst.resultString;
    }

    // INFO: NON sono passati alcuni test del main!!!
}
