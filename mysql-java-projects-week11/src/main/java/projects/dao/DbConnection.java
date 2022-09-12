package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {
	//declaring constant variables
	private static final String SCHEMA = "projects";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final int PORT = 3306;
	private static final String HOST = "localhost";
	
	//this method creates a connection to database and returns connection
	public static Connection getConnection() {	
		
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s",
				HOST, PORT, SCHEMA, USER, PASSWORD);		
		System.out.println("Connecting with uri" + uri);
		
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Successfully obtained connection!");
			return conn;
		} catch (SQLException e) {
			throw new DbException(e);
		}				
	}
}
