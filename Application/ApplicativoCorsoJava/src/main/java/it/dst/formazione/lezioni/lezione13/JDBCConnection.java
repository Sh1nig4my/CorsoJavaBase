package it.dst.formazione.lezioni.lezione13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/corso_java";
    private static final String USER = "root";
    private static final String PASSWORD = "011092"; // Sostituisci con la tua password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
