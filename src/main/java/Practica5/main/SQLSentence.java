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
            String sql = sentence.trim();

            PreparedStatement stmt = connection.prepareStatement(sql);

            if (sql.toUpperCase().startsWith("SELECT")) {
                ResultSet rs = stmt.executeQuery();
                Printer.print(rs);
                rs.close();
            } else {
                int rows = stmt.executeUpdate();
            }

            stmt.close();
        } catch (Exception e) {
            System.out.println("ERROR: The database operation has fail.");
            e.printStackTrace();
        }
    }
}
