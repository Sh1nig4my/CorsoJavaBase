package it.dst.formazione.lezioni.lezione13.crud;

import it.dst.formazione.lezioni.lezione13.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_delete {

    public void eliminaUtente(int id) {
        String query = "DELETE FROM utenti WHERE id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int righeEliminate = pstmt.executeUpdate();
            if (righeEliminate > 0) {
                System.out.println("Utente eliminato con successo!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Jdbc_delete eliminatore = new Jdbc_delete();
        eliminatore.eliminaUtente(1);
    }

}
