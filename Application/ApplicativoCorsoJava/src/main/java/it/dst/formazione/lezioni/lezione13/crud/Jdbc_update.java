package it.dst.formazione.lezioni.lezione13.crud;

import it.dst.formazione.lezioni.lezione13.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_update {

    public void aggiornaEmail(int id, String nuovaEmail) {
        String query = "UPDATE utenti SET email = ? WHERE id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nuovaEmail);
            pstmt.setInt(2, id);

            int righeAggiornate = pstmt.executeUpdate();
            if (righeAggiornate > 0) {
                System.out.println("Email aggiornata con successo!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Jdbc_update aggiornatore = new Jdbc_update();
        aggiornatore.aggiornaEmail(1, "mario.rossi@nuovodominio.com");
    }

}
