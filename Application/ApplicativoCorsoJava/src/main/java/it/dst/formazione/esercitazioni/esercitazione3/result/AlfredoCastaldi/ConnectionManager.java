package it.dst.formazione.esercitazioni.esercitazione3.result.AlfredoCastaldi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/library"; // la URL era presente nell'interfaccia
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    // INFO: non poteva essere inserito nella stessa classe??
    public static Connection getConnection() {
        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }
}