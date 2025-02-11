package id.dst.game.repository.scenario;

import id.dst.game.entity.scenario.Scenario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ScenarioRepository {

    String createTable() throws SQLException;

    String insertScenario(Scenario scenario) throws SQLException;

    Optional<Scenario> selectScenarioById(Integer id) throws SQLException;

    List<Scenario> selectAllScenarios() throws SQLException;

    String deleteScenarioById(Integer id) throws SQLException;

}
