package id.dst.game.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOManager {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/game";
	private static final String USER = "root";
	private static final String PASSWORD = "011092";

	public Connection conn = null;

	public void getConnection() throws SQLException {
        if (this.conn == null || this.conn.isClosed()) { // Controlla se la connessione è già aperta
            this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
    }

	public Boolean isClosed() throws SQLException {
        if (this.conn != null)
            return this.conn.isClosed();
        return true;
	}
	
	public void close() throws SQLException {
        if (this.conn != null && !this.conn.isClosed()) {
            this.conn.close();
            this.conn = null;  // Assicura che la connessione venga "resettata"
        }
    }


}
