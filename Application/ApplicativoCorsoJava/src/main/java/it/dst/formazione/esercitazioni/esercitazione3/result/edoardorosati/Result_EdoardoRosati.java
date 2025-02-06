package it.dst.formazione.esercitazioni.esercitazione3.result.edoardorosati;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


//String createTableLibro();
//String testInserimento();
//List<Libro> testSelezione();
//List<Libro> testSelezioneFiltrata(boolean disponibile);
//String testAggiornamentoDisponibilita(int idLibro, boolean disponibile);
//String testEliminazione(int idLibro);


public class Result_EdoardoRosati implements BibliotecaInterface {

    // TODO: potrebbe essere una soluzione la cattura di una ecceione specifica per SQL e propagare l'errore? Parlo per tutti i metodi

    public static class DatabaseConnection {
        // TODO: perchè una classe dentor una classe? Non può essere evitata questa annidazione?
        private static final String URL = "jdbc:mysql://localhost:3306/biblioteca"; // TODO: prendi la url dall'interfaccia InputOutputConst
        private static final String USER = "root";
        private static final String PASSWORD = "011092";

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Errore di connessione al database: " + e.getMessage());
                return null;
            }
        }
    }

    @Override
    public String createTableLibro() {
        // TODO: prendi la query dall'interfaccia InputOutputConst
        String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) { // TODO: c'èun modo per evitare il warning?

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }
        return query; // TODO: attenzione al risultato atteso di ritorno
    }

    @Override
    public String testInserimento() {
        // TODO: Prendendo la lista libri nell'interfaccia ci sono da inserire tutti quei libri presenti nellalista, metodo incompleto
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aggiungi nuovo libro");
        System.out.print("Inserisci il titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci l'autore: ");
        String autore = scanner.nextLine();
        int anno = annoInput();

        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: c'èun modo per evitare il warning?
            pstmt.setString(1, titolo);
            pstmt.setString(2, autore);
            pstmt.setInt(3, anno);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Libro aggiunto correttamente");
            }
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return query; // TODO: attenzione al risultato atteso di ritorno
    }

    private static int annoInput() {
        //TODO: in più per il tipo di esercitazione
        Scanner scanner = new Scanner(System.in);
        int annoIn = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Inserisci l'anno di pubblicazione: ");
            try {
                annoIn = scanner.nextInt();
                scanner.nextLine();
                if (String.valueOf(annoIn).length() > 4) {
                    System.out.println("Input errato: l'anno non può avere più di 4 cifre!");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input errato: l'anno non può contenere lettere!");
                scanner.nextLine();
            }
        }
        return annoIn;
    }

    @Override
    public List<Libro> testSelezione() {

        System.out.println("Libri in ordine di ID:");

        String query = "SELECT * FROM libri";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query); // TODO: c'èun modo per evitare il warning?
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
        return List.of(); // TODO: attenzione al risultato atteso di ritorno: perchè la lista vuota?
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {

        System.out.println("Libri in ordine di pubblicazione:");

        String query = "SELECT * FROM libri ORDER BY anno_pubblicazione ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query); // TODO: c'èun modo per evitare il warning?
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
        return List.of(); // TODO: attenzione al risultato atteso di ritorno: perchè la lista vuota?
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        Scanner scanner = new Scanner(System.in);

        // TODO: perchè questa porzione di codice? Se prendi in input i valori idLibro e disponibilità, perchè poi chiedere all'utente delle informazioni?
        System.out.println("Inserisci l'ID del libro di cui vuoi modificare la disponibilità:");
        int idDisponibilita = scanner.nextInt();
        System.out.println("Il libro è disponibile? (True=Sì False=No)");
        boolean verofalso = scanner.nextBoolean(); // FIXME: inserendo "No" si spacca tutto!!!!

        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: c'èun modo per evitare il warning?

            pstmt.setBoolean(1, verofalso);
            pstmt.setInt(2, idDisponibilita);
            pstmt.executeUpdate();

            System.out.println("Disponibilità aggiornata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'aggiornamento: " + e.getMessage());
        }
        return query; // TODO: attenzione al risultato atteso di ritorno
    }

    @Override
    public String testEliminazione(int idLibro) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci l'Id del libro vuoi eliminare:");
        int idEliminazione = scanner.nextInt();

        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // TODO: c'è un modo per evitare il warning?

            pstmt.setInt(1, idEliminazione);
            pstmt.executeUpdate();

            System.out.println("Libro eliminato con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
        }
        return query; // TODO: attenzione al risultato atteso di ritorno
    }

// INFO: per via dei tuoi return dei metodo nel main non passa quasi nulla

}
