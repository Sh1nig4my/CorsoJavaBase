package id.dst.game.repository.giocatore;

import id.dst.game.entity.giocatore.Giocatore;
import id.dst.game.repository.DAOManager;
import id.dst.game.tools.EntityEnum;
import id.dst.game.tools.ResultEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GiocatoreDAO extends DAOManager implements CRUDGiocatore {

    @Override
    public String createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + EntityEnum.GIOCATORE.getTableName() + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "eta INT NOT NULL, " +
                "hp INT NOT NULL, " +
                "forza INT NOT NULL, " +
                "destrezza INT NOT NULL, " +
                "intelligenza INT NOT NULL, " +
                "tipo VARCHAR(50) NOT NULL" +
                ");";
        boolean resultQuery;

        try {
            getConnection();
            Statement stmt = conn.createStatement();
            resultQuery = stmt.execute(sql);
            System.out.println("Tabella Giocatori creata con successo.");

        } catch (SQLException e) {
            throw new SQLException("Errore nella creazione della tabella: " + e.getMessage());
        } finally {
            close();
        }

        return resultQuery ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();
    }

    @Override
    public String insertGiocatore(Giocatore giocatore) throws SQLException {
        String sql = "INSERT INTO " + EntityEnum.GIOCATORE.getTableName() + " (nome, eta, hp, forza, destrezza, intelligenza, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int resultQuery;
        try {
            getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, giocatore.getNome());
            pstmt.setInt(2, giocatore.getEta());
            pstmt.setInt(3, giocatore.getHp());
            pstmt.setInt(4, giocatore.getForza());
            pstmt.setInt(5, giocatore.getDestrezza());
            pstmt.setInt(6, giocatore.getIntelligenza());
            pstmt.setString(7, giocatore.getTipo());
            resultQuery = pstmt.executeUpdate();
            System.out.println("Giocatore inserito con successo.");
        } catch (SQLException e) {
            throw new SQLException("Errore nell'inserimento del giocatore: " + e.getMessage());
        } finally {
            close();
        }

        return resultQuery == 0 ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();
    }

    @Override
    public String updateGiocatoreById(Integer id, Giocatore giocatore) throws SQLException {
        String sql = "UPDATE " + EntityEnum.GIOCATORE.getTableName() + " SET nome = ?, eta = ?, hp = ?, forza = ?, destrezza = ?, intelligenza = ?, tipo = ? WHERE id = ?";
        int resultQuery;
        try {
            getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, giocatore.getNome());
            pstmt.setInt(2, giocatore.getEta());
            pstmt.setInt(3, giocatore.getHp());
            pstmt.setInt(4, giocatore.getForza());
            pstmt.setInt(5, giocatore.getDestrezza());
            pstmt.setInt(6, giocatore.getIntelligenza());
            pstmt.setString(7, giocatore.getTipo());
            pstmt.setInt(8, id);
            resultQuery = pstmt.executeUpdate();
            System.out.println("Giocatore aggiornato con successo.");
        } catch (SQLException e) {
            throw new SQLException("Errore nell'aggiornamento del giocatore: " + e.getMessage());
        } finally {
            close();
        }

        return resultQuery == 0 ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();
    }

    @Override
    public Optional<Giocatore> selectGiocatoreById(Integer id) throws SQLException {
        String sql = "SELECT * FROM " + EntityEnum.GIOCATORE.getTableName() + " WHERE id = ?";
        try {
            getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Giocatore giocatore = new Giocatore(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("eta"),
                        rs.getInt("hp"),
                        rs.getInt("forza"),
                        rs.getInt("destrezza"),
                        rs.getInt("intelligenza"),
                        rs.getString("tipo")
                );
                return Optional.of(giocatore);
            }
        } catch (SQLException e) {
            throw new SQLException("Errore nella selezione del giocatore: " + e.getMessage());
        } finally {
            close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Giocatore>> selectAllGiocatore() throws SQLException {
        String sql = "SELECT * FROM " + EntityEnum.GIOCATORE.getTableName();
        List<Giocatore> giocatori = new ArrayList<>();
        try {
            getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Giocatore giocatore = new Giocatore(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("eta"),
                        rs.getInt("hp"),
                        rs.getInt("forza"),
                        rs.getInt("destrezza"),
                        rs.getInt("intelligenza"),
                        rs.getString("tipo")
                );
                giocatori.add(giocatore);
            }
        } catch (SQLException e) {
            throw new SQLException("Errore nella selezione di tutti i giocatori: " + e.getMessage());
        } finally {
            close();
        }
        return Optional.of(giocatori);
    }

    @Override
    public String cancellaGiocatoreById(Integer id) throws SQLException {
        String sql = "DELETE FROM " + EntityEnum.GIOCATORE.getTableName() + " WHERE id = ?";
        int resultQuery;
        try {
            getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            resultQuery = pstmt.executeUpdate();
            System.out.println("Giocatore eliminato con successo.");
        } catch (SQLException e) {
            throw new SQLException("Errore nella cancellazione del giocatore: " + e.getMessage());
        } finally {
            close();
        }

        return resultQuery == 0 ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();
    }

}
