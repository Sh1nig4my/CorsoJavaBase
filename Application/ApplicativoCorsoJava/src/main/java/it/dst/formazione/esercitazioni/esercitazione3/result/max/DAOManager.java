package it.dst.formazione.esercitazioni.esercitazione3.result.max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOManager {
	private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
	private static final String USER = "root";
	private static final String PASSWORD = "R3ziel&80";

	public enum Table {
		LIBRO
	}

	private Connection conn = null;

	public void getConnection() throws SQLException {
		try {
			if (this.conn == null)
				this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw e;
		}
	}

	public void close() throws SQLException {
		try {
			if (this.conn != null)
				this.conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	public GenericDAO getDAO(Table t) throws SQLException {

		try {
			if (this.conn == null || this.conn.isClosed()) // Let's ensure our connection is open
				getConnection();
		} catch (SQLException e) {
			throw e;
		}

		switch (t) {
		case LIBRO:
			return new LibriDAO(this.conn);

		default:
			throw new SQLException("Trying to link to an unexistant table.");
		}

	}

}
