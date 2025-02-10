package id.dst.game.repository.giocatore;

import id.dst.game.entity.giocatore.Giocatore;
import id.dst.game.repository.DAOManager;
import id.dst.game.tools.EntityEnum;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GiocatoreDAO extends DAOManager implements CRUDGiocatore {

    @Override
    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + EntityEnum.GIOCATORE + " (" +
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
            System.out.println("Tabella Giocatori creata con successo.");

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void insertGiocatore(Giocatore giocatore) throws SQLException {

    }

    @Override
    public void updateGiocatoreById(Integer id, Giocatore giocatore) throws SQLException {

    }

    @Override
    public Giocatore selectGiocatoreById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Giocatore> selectAllGiocatore() throws SQLException {
        return List.of();
    }

    @Override
    public void cancellaGioctoreById(Integer id) {

    }


}

