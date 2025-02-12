package id.dst.game.example.repository.scenario;

import id.dst.game.example.entity.scenario.Scenario;
import id.dst.game.example.repository.DAOManager;
import id.dst.game.example.tools.EntityEnum;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ScenarioDAO extends DAOManager implements ScenarioRepository {

    private static final Logger log = Logger.getLogger(ScenarioDAO.class.getName());

    @Override
    public Boolean createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + EntityEnum.SCENARIO.getTableName() + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "descrizione TEXT NOT NULL);";

        try {
            getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            log.info("Tabella Scenario creata con successo.");
        } catch (SQLException e) {
            log.severe("Errore nella creazione della tabella Scenario: " + e.getMessage());
            throw new SQLException("Errore nella creazione della tabella Scenario: " + e.getMessage());
        } finally {
            close();
        }
        return true;
    }

    @Override
    public Boolean insertScenario(Scenario scenario) throws SQLException {
        return true;
    }

    @Override
    public Optional<Scenario> selectScenarioById(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Scenario> selectAllScenarios() throws SQLException {
        return List.of();
    }

    @Override
    public Boolean deleteScenarioById(Integer id) throws SQLException {
        return true;
    }

}
