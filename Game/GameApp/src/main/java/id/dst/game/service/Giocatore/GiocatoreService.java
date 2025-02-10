package id.dst.game.service.Giocatore;

import id.dst.game.repository.giocatore.GiocatoreDAO;

import java.sql.SQLException;

public class GiocatoreService {

    private final GiocatoreDAO giocatoreDAO = new GiocatoreDAO();

    public void initialize() throws SQLException {
        giocatoreDAO.createTable();
    }




}

