package it.dst.formazione.lezioni.lezione13.crud;

import it.dst.formazione.lezioni.lezione13.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_read {

    public void mostraUtenti() {
        String query = "SELECT * FROM utenti";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Jdbc_read lettore = new Jdbc_read();
        lettore.mostraUtenti();
    }

}
