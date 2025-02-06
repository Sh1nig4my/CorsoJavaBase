package it.dst.formazione.esercitazioni.esercitazione3.result;

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

    public static class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
        private static final String USER = "root";
        private static final String PASSWORD = "Deryltwd9";

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
        String query = "CREATE TABLE IF NOT EXISTS libri ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titolo VARCHAR(100) NOT NULL, "
                + "autore VARCHAR(100) NOT NULL, "
                + "anno_pubblicazione INT NOT NULL, "
                + "disponibile BOOLEAN DEFAULT TRUE)";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(query);
            System.out.println("Tabella 'libri' creata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nella creazione della tabella: " + e.getMessage());
        }
        return query;
    }

    @Override
    public String testInserimento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aggiungi nuovo libro");
        System.out.print("Inserisci il titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci l'autore: ");
        String autore = scanner.nextLine();
        int anno = annoInput();


        String query = "INSERT INTO libri (titolo, autore, anno_pubblicazione) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, titolo);
            pstmt.setString(2, autore);
            pstmt.setInt(3, anno);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Libro aggiunto correttamente");
            }
        }
        catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }
        return query;
    }

    private static int annoInput() {
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
        return List.of();
    }

    @Override
    public List<Libro> testSelezioneFiltrata(boolean disponibile) {

        System.out.println("Libri in ordine di pubblicazione:");

        String query = "SELECT * FROM libri ORDER BY anno_pubblicazione ASC";

        try (Connection conn = DatabaseConnection.getConnection();
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
        return List.of();
    }

    @Override
    public String testAggiornamentoDisponibilita(int idLibro, boolean disponibile) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Inserisci l'ID del libro di cui vuoi modificare la disponibilità:");
        int idDisponibilita = scanner.nextInt();
        System.out.println("Il libro è disponibile? (True=Sì False=No)");
        boolean verofalso = scanner.nextBoolean();

        String query = "UPDATE libri SET disponibile = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, verofalso);
            pstmt.setInt(2, idDisponibilita);
            pstmt.executeUpdate();

            System.out.println("Disponibilità aggiornata con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'aggiornamento: " + e.getMessage());
        }
        return query;
    }

    @Override
    public String testEliminazione(int idLibro) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci l'Id del libro vuoi eliminare:");
        int idEliminazione = scanner.nextInt();

        String query = "DELETE FROM libri WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idEliminazione);
            pstmt.executeUpdate();

            System.out.println("Libro eliminato con successo.");

        } catch (SQLException e) {
            System.err.println("Errore nell'eliminazione: " + e.getMessage());
        }
        return query;
    }





}
