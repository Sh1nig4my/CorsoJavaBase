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

	public void getConnection() {
		try {
			if (this.conn == null)
				this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean isClosed() throws SQLException {
		try {
			if (this.conn != null)
				return this.conn.isClosed();
		} catch (SQLException e) {
			throw e;
		}
		return true;
	}
	
	public void closeConnection() {
		try{
			if (this.conn != null && !isClosed())
				this.conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public GenericDAO getDAO(Table t) throws SQLException {

		
		switch (t) {
		case LIBRO:
			return new LibriDAO(this.conn);

		default:
			throw new SQLException("Trying to link to an unexistant table.");
		}

	}

}
