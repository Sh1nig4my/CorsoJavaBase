package id.dst.game.service;

import id.dst.game.service.giocatore.GiocatoreService;
import id.dst.game.service.scenario.ScenarioService;

import java.util.logging.Logger;

public class GameService {

    private static final Logger log = Logger.getLogger(GameService.class.getName());
    private static final GiocatoreService giocatoreService = new GiocatoreService();
    private static final ScenarioService scenarioService = new ScenarioService();

    // INFO: fase di inizializzazione del gioco
    //  (creazione delle tabelle e dei attributi necessari)
    public static String configGame() {

        String resultConfig;

        resultConfig = giocatoreService.createTable();

        // TODO creo tutte le entity necessarie

        // TODO popolo il gioco con le oinfo di base

        // TODO verifico che il giocatore ha già un salvataggio attivo

        return resultConfig;

    }


    public static String startGame() {

        return "resultConfig";

    }

}
