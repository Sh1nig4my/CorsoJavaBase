package id.dst.game.repository.giocatore;

import id.dst.game.entity.giocatore.Giocatore;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CRUDGiocatore {

    String createTable() throws SQLException;

    String insertGiocatore(Giocatore giocatore) throws SQLException;

    String updateGiocatoreById(Integer id, Giocatore giocatore) throws SQLException;

    Optional<Giocatore> selectGiocatoreById(Integer id) throws SQLException;

    Optional<List<Giocatore>> selectAllGiocatore() throws SQLException;

    String cancellaGiocatoreById(Integer id) throws SQLException;

}
