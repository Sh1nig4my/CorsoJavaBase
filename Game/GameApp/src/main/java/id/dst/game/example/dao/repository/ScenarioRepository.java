package id.dst.game.example.dao.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import id.dst.game.example.entity.Scenario;

public interface ScenarioRepository {

    Boolean createTable() throws SQLException;

    Boolean insertScenario(Scenario scenario) throws SQLException;

    Optional<Scenario> selectScenarioById(Integer id) throws SQLException;

    List<Scenario> selectAllScenarios() throws SQLException;

    Boolean deleteScenarioById(Integer id) throws SQLException;

}
