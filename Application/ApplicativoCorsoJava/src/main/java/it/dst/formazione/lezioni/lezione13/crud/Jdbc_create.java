package it.dst.formazione.lezioni.lezione13.crud;

import it.dst.formazione.lezioni.lezione13.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_create {

    public void aggiungiUtente(String nome, String email) {
        String query = "INSERT INTO utenti (nome, email) VALUES (?, ?)";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, email);

            int righeInserite = pstmt.executeUpdate();
            if (righeInserite > 0) {
                System.out.println("Utente aggiunto con successo!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Jdbc_create dao = new Jdbc_create();
        dao.aggiungiUtente("Mario Rossi", "mario.rossi@email.com");
    }

}
