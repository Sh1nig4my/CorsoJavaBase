package id.dst.game.example.repository.giocatore;

import id.dst.game.example.entity.giocatore.Giocatore;
import id.dst.game.example.repository.DAOManager;
import id.dst.game.example.tools.EntityEnum;
import id.dst.game.example.tools.ResultEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class GiocatoreDAO extends DAOManager implements GiocatoreRepository {

    private static final Logger log = Logger.getLogger(GiocatoreDAO.class.getName());

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

        try {
            getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            log.info("Tabella Giocatori creata con successo.");

        } catch (SQLException e) {
            log.severe("Errore nella creazione della tabella: " + e.getMessage());
            throw new SQLException("Errore nella creazione della tabella: " + e.getMessage());
        } finally {
            close();
        }

        return ResultEnum.OK.getResultEnum();
    }

    @Override
    public String insertGiocatore(Giocatore giocatore) throws SQLException {
        String sql = "INSERT INTO " + EntityEnum.GIOCATORE.getTableName() +
                     " (nome, eta, hp, forza, destrezza, intelligenza, tipo) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        int resultQuery;
        PreparedStatement pstmt = null;
        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, giocatore.getNome());
            pstmt.setInt(2, giocatore.getEta());
            pstmt.setInt(3, giocatore.getHp());
            pstmt.setInt(4, giocatore.getForza());
            pstmt.setInt(5, giocatore.getDestrezza());
            pstmt.setInt(6, giocatore.getIntelligenza());
            pstmt.setString(7, giocatore.getTipo());
            resultQuery = pstmt.executeUpdate();

            if (resultQuery > 0) {
                log.info("Giocatore inserito con successo: " + giocatore.getNome());
            } else {
                log.warning("Fallito l'inserimento del giocatore: " + giocatore.getNome());
            }

            // INFO: Il valore di ritorno di executeUpdate() è il numero di righe aggiornate, quindi la condizione  è invertita.
            return resultQuery > 0 ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();

        } catch (SQLException e) {
            throw new SQLException("Errore nell'inserimento del giocatore: " + e.getMessage());
        } finally {
            if (pstmt != null) pstmt.close();
            close();
        }

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
            if (resultQuery > 0) {
                log.info("Giocatore aggiornato con successo: " + giocatore.getNome());
            } else {
                log.warning("Fallito l'aggiornamento del giocatore: " + giocatore.getNome());
            }

            // INFO: Il valore di ritorno di executeUpdate() è il numero di righe aggiornate, quindi la condizione  è invertita.
            return resultQuery > 0 ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();

        } catch (SQLException e) {
            throw new SQLException("Errore nell'aggiornamento del giocatore: " + e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public Optional<Giocatore> selectGiocatoreById(Integer id) throws SQLException {
        String sql = "SELECT * FROM " + EntityEnum.GIOCATORE.getTableName() + " WHERE id = ?";
        // INFO: chiudere la connessione nel blocco finally potrebbe causare problemi quando l'Optional<> viene letto all'esterno
        Giocatore giocatore = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                giocatore = new Giocatore(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("eta"),
                        rs.getInt("hp"),
                        rs.getInt("forza"),
                        rs.getInt("destrezza"),
                        rs.getInt("intelligenza"),
                        rs.getString("tipo")
                );
            }

            return Optional.ofNullable(giocatore);

        } catch (SQLException e) {
            log.severe("Errore nella selezione del giocatore con ID " + id + ": " + e.getMessage());
            throw new SQLException("Errore nella selezione del giocatore: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            close();
        }

    }

    @Override
    public List<Giocatore> selectAllGiocatore() throws SQLException {
        String sql = "SELECT * FROM " + EntityEnum.GIOCATORE.getTableName();
        List<Giocatore> giocatori = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

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

            return giocatori;

        } catch (SQLException e) {
            throw new SQLException("Errore nella selezione di tutti i giocatori: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            close();
        }

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

            if (resultQuery > 0) {
                log.info("Giocatore con ID " + id + " eliminato con successo.");
            } else {
                log.warning("Nessun giocatore trovato con ID " + id + ". Eliminazione fallita.");
            }

            return resultQuery > 0 ? ResultEnum.OK.getResultEnum() : ResultEnum.KO.getResultEnum();
        } catch (SQLException e) {
            log.severe("Errore nella cancellazione del giocatore: " + e.getMessage());
            throw new SQLException("Errore nella cancellazione del giocatore: " + e.getMessage());
        } finally {
            close();
        }

    }

}
