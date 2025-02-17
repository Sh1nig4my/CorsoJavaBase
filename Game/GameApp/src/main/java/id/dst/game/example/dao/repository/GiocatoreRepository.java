package id.dst.game.example.dao.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import id.dst.game.example.entity.Giocatore;

public interface GiocatoreRepository {

    Boolean createTable() throws SQLException;

    Boolean insertGiocatore(Giocatore giocatore) throws SQLException;

    Boolean updateGiocatoreById(Integer id, Giocatore giocatore) throws SQLException;

    Optional<Giocatore> selectGiocatoreById(Integer id) throws SQLException;

    List<Giocatore> selectAllGiocatore() throws SQLException;

    Boolean cancellaGiocatoreById(Integer id) throws SQLException;

}
