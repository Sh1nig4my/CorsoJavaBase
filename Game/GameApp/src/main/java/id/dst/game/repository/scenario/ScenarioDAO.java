package id.dst.game.repository.scenario;

import id.dst.game.entity.scenario.Scenario;
import id.dst.game.repository.DAOManager;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ScenarioDAO extends DAOManager implements ScenarioRepository {


    @Override
    public String createTable() throws SQLException {
        return "";
    }

    @Override
    public String insertScenario(Scenario scenario) throws SQLException {
        return "";
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
    public String deleteScenarioById(Integer id) throws SQLException {
        return "";
    }

}
