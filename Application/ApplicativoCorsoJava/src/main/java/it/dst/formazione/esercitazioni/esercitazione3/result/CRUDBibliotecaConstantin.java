import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRUDBibliotecaConstantin implements BibliotecaInterface {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }
    @Override
    public String createTableLibro() {
        String query = "CREATE TABLE IF NOT EXISTS libri (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "titolo VARCHAR(100) NOT NULL, " +
                "autore VARCHAR(100) NOT NULL, " +
                "anno_pubblicazione INT NOT NULL, " +
                "disponibile BOOLEAN DEFAULT TRUE)";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            return "Tabella 'libri' creata con successo.";
        } catch (SQLException e) {
            return "Errore nella creazione della tabella: " + e.getMessage();
        }
    }

    @Override
    public String testInserimento() {
        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione, disponibile) VALUES (?, ?, ?, ?)";
        List<Libro> libri = Arrays.asList(
                new Libro("I Promessi Sposi", "Alessandro Manzoni", 1827, true),
                new Libro("1984", "George Orwell", 1949, true),
                new Libro("Il Piccolo Principe", "Antoine de Saint-Exupéry", 1943, true),
                new Libro("Harry Potter e la Pietra Filosofale", "J.K. Rowling", 1997, true),
                new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 1954, false),
                new Libro("Il Nome della Rosa", "Umberto Eco", 1980, true),
                new Libro("Orgoglio e Pregiudizio", "Jane Austen", 1813, true),
                new Libro("Delitto e Castigo", "Fëdor Dostoevskij", 1866, true),
                new Libro("Il Processo", "Franz Kafka", 1925, true),
                new Libro("Moby Dick", "Herman Melville", 1851, true),
                new Libro("Geronimo Stilton", "Elisabetta Dami",1997, false)
        );

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (Libro libro : libri) {
                pstmt.setString(1, libro.getTitolo());
                pstmt.setString(2, libro.getAutore());
                pstmt.setInt(3, libro.getAnnoPubblicazione());
                pstmt.setBoolean(4, libro.isDisponibile());
                pstmt.executeUpdate();
            }
            System.out.println("Libro inserito con successo.");
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return "";
    }

    @Override
    public List<Libro> testSelezione() {
        List<Libro> libri = new ArrayList<>();
        String query = "SELECT * FROM libri";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
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
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
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
            System.err.println("Errore durante il recupero dati filtrati: " + e.getMessage());
        }
        return libri;
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, disponibile);
            pstmt.setInt(2, idLibro);
            pstmt.executeUpdate();
            return "Disponibilità aggiornata con successo.";
        } catch (SQLException e) {
            return "Errore nell'aggiornamento della disponibilità: " + e.getMessage();
        }
    }

    @Override
    public String testEliminazione(int idLibro) {
        String query = "DELETE FROM libri WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLibro);
            pstmt.executeUpdate();
            return "Libro eliminato con successo.";
        } catch (SQLException e) {
            return "Errore nell'eliminazione del libro: " + e.getMessage();
        }
    }
}

