package Practica5.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLSentence {

	private String sentence;
	
	SQLSentence() {
		this.sentence = "";
	}
	
	void add(String line) {
		this.sentence += line + "\n";
	}
	
	void execute() {	
		try {
			Connection connection = ConnectionVault.get();
			PreparedStatement stmt = connection.prepareStatement(sentence);
			ResultSet rs = stmt.executeQuery();
			Printer.print(rs);
		} catch (Exception e) {
			System.out.println("ERROR: The database operation has fail.");
			e.printStackTrace();
		}
	}
}
