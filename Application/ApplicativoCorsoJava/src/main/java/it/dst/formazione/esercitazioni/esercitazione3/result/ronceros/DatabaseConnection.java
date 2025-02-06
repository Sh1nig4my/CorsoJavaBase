package it.dst.formazione.esercitazioni.esercitazione3.result.ronceros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Metodo per ottenere la connessione al database
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/biblioteca";  // Inserisci l'URL del tuo database
        String user = "root";  // Username
        String password = "admin";  // Password

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Errore nella connessione al database: " + e.getMessage());
            // Puoi lanciare un'eccezione personalizzata o restituire null, a seconda delle necessità
            return null;
        }
    }
}
