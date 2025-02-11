package id.dst.game;

import id.dst.game.example.service.GameService;

import java.sql.SQLException;

public class MainExample {

    public static void main(String[] args) throws SQLException {

        final GameService gameService = new GameService();

        System.out.println("STAR GAME!!!");

        // 1. Inizializzazione degli strumenti di gioco
        Boolean configGame = GameService.configGame();
        if (!configGame) {
            // INFO: chiudo subito l'applicativo
            //  poiché la fase di inizializzazione non è andata a buon fine

            System.err.println("NO CONFIG");
        }

        GameService.startGame();

        System.out.println("END GAME!!!");

    }

}