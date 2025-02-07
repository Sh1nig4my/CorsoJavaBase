package it.dst.formazione.esercitazioni.esercitazione3.result.DarioFlavioScipioni;

import it.dst.formazione.tools.InputOutputConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {

    // TODO: la URL sta nell'interfaccia InputOutputConst
    //private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String URL = InputOutputConst.URL;
    private static final String USER = "root";
    //private static final String PASSWORD = "011092";
    private static final String PASSWORD = "root";

    public static Connection getConnectionProva() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
            return null;
        }
    }
}
