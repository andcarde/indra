package Practica5.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionVault {

	private static Connection instance;
	private static final String URL  = "jdbc:mysql://localhost:3306/clinica";
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	static Connection get() {
		if (ConnectionVault.instance == null)
			ConnectionVault.makeConnection();
		
		return ConnectionVault.instance;
	}

	private static void testDriver() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("TEST: Driver Found");
	    } catch (ClassNotFoundException cnfe) {
	        System.out.println("ERROR: Missing Driver no encontrado");
	    }
	}

	private static void makeConnection() {
		testDriver();
		
		try {
			ConnectionVault.instance = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException sqle) {
			System.out.println("ERROR: The database connection could not be established.");
		}
	}
}
