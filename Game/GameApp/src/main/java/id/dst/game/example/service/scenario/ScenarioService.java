package id.dst.game.example.service.scenario;

import id.dst.game.example.repository.scenario.ScenarioDAO;

import java.sql.SQLException;
import java.util.logging.Logger;

public class ScenarioService {

    private static final Logger log = Logger.getLogger(ScenarioService.class.getName());
    private final ScenarioDAO scenarioDAO = new ScenarioDAO();


    public Boolean createTable() {
        try {
            return scenarioDAO.createTable();
        } catch (SQLException e) {
            log.warning("Errore nella creazione della tabella scenario: " + e.getMessage());
            return false;
        }
    }

}
