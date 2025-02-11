package id.dst.game;

import id.dst.game.example.service.GameService;
import id.dst.game.example.tools.ResultEnum;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        final GameService gameService = new GameService();

        System.out.println("STAR GAME!!!");

        // 1. Inizializzazione degli strumenti di gioco
        String resultInizialize = GameService.configGame();
        if (!resultInizialize.equalsIgnoreCase(ResultEnum.KO.getResultEnum())) {
            // INFO: chiudo subito l'applicativo
            //  poiché la fase di inizializzazine non è andata a buon fine

        } else {
            return;
        }

        // Altrimenti passo al passaggio successivo

        // 2. Avviare una nuova partita,


    }

}