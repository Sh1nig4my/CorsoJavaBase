package id.dst.game.service;

import id.dst.game.service.giocatore.GiocatoreService;
import id.dst.game.tools.ResultEnum;

import java.sql.SQLException;

public class GameService {

    private static final GiocatoreService giocatoreService = new GiocatoreService();


    // INFO: fase di inizializzazione del gioco
    //  (creazione delle tabelle e dei attributi necessari)
    public static String configGame() {

        String resultConfig;

        try {
            resultConfig = giocatoreService.createTable();

        } catch (SQLException e) {
            System.err.println("ERROR GameService - configGame()  : " + e.getMessage());
            return ResultEnum.KO.getResultEnum();
        }


        /*try {
            // TODO: crea Tabella Scenario
        } catch (SQLException e) {
            System.err.println("ERROR GameService - configGame() : " + e.getMessage());
            return ResultEnum.KO.getResultEnum();
        }*/

        return resultConfig;

    }

    public static String selectPG() {

        return "";
    }


}
