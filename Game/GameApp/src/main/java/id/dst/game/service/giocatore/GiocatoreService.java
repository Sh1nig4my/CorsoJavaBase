package id.dst.game.service.giocatore;

import id.dst.game.repository.giocatore.GiocatoreDAO;
import id.dst.game.tools.ResultEnum;

import java.sql.SQLException;

public class GiocatoreService {

    private final GiocatoreDAO giocatoreDAO = new GiocatoreDAO();

    // INFO: fase di inizializzazione del gioco
    //  (creazione delle tabelle e dei attributi necessari)
    public String createTable() throws SQLException {

        //INFO: ritona 0 se OK, 1 se c'è stato un errore
        try {
            giocatoreDAO.createTable();

        } catch (SQLException e) {
            System.err.println("ERROR GiocatoreService - initialize() : " + e.getMessage());
            if (!giocatoreDAO.isClosed())
                giocatoreDAO.close();
            return ResultEnum.KO.getResultEnum();
        }

        return ResultEnum.OK.getResultEnum();

    }


}

