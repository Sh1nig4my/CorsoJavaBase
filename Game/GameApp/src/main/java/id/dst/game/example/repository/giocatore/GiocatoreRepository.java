package id.dst.game.example.repository.giocatore;

import id.dst.game.example.entity.giocatore.Giocatore;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GiocatoreRepository {

    Boolean createTable() throws SQLException;

    Boolean insertGiocatore(Giocatore giocatore) throws SQLException;

    Boolean updateGiocatoreById(Integer id, Giocatore giocatore) throws SQLException;

    Optional<Giocatore> selectGiocatoreById(Integer id) throws SQLException;

    List<Giocatore> selectAllGiocatore() throws SQLException;

    Boolean cancellaGiocatoreById(Integer id) throws SQLException;

}
