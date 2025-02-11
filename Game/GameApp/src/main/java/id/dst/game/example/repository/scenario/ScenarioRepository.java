package id.dst.game.example.repository.scenario;

import id.dst.game.example.entity.scenario.Scenario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ScenarioRepository {

    Boolean createTable() throws SQLException;

    Boolean insertScenario(Scenario scenario) throws SQLException;

    Optional<Scenario> selectScenarioById(Integer id) throws SQLException;

    List<Scenario> selectAllScenarios() throws SQLException;

    Boolean deleteScenarioById(Integer id) throws SQLException;

}
