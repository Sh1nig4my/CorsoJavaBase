package id.dst.game.example.service;

import java.util.logging.Logger;

public class GameService {

    private static final Logger log = Logger.getLogger(GameService.class.getName());
    private static final GiocatoreService giocatoreService = new GiocatoreService();
    private static final ScenarioService scenarioService = new ScenarioService();

    // INFO: fase di inizializzazione del gioco
    //  (creazione delle tabelle e dei attributi necessari)
    public static Boolean configGame() {
        Boolean resultConfig;

        resultConfig = giocatoreService.createTable();
        if (!resultConfig) return false;

        resultConfig = scenarioService.createTable();
        if (!resultConfig) return false;

        // TODO creo tutte le entity necessarie

        // TODO popolo il gioco con le info di base

        return true;
    }


    public static void startGame() {

        // TODO inizio della meccanica di gioco:
        //  1. creazione nuovo personaggio
        //  2. scelta dello scenario di gioco
        //  3. meccanica da implementare

    }

}
