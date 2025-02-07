package it.dst.formazione.esercitazioni.esercitazione3.result.valerioAlunno;

import it.dst.formazione.esercitazioni.esercitazione3.BibliotecaInterface;
import it.dst.formazione.esercitazioni.esercitazione3.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ValerioAlunnoLibreria{

        private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
        private static final String USER = "root";
        private static final String PASSWORD = "valerio";

        public static  Connection getConnection() {
            try {

                return DriverManager.getConnection(URL, USER, PASSWORD);

            } catch (SQLException e) {
                System.out.println("Errore di connessione al database: " + e.getMessage());
                return null;
            }

}}

