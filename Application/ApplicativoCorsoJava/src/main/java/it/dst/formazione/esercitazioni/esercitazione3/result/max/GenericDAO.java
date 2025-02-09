package it.dst.formazione.esercitazioni.esercitazione3.result.max;

import java.sql.Connection;

public abstract class GenericDAO {

	private final String tableName;
	protected Connection conn;

	protected GenericDAO(Connection con, String tableName) {
		this.tableName = tableName;
		this.conn = con;
	}
}
