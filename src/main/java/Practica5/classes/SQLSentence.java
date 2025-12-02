package Practica5.classes;

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

    /**
     * Para sentencias SELECT (devuelve ResultSet y lo imprime).
     */
    void executeQuery() {
        try {
            Connection connection = ConnectionVault.get();
            if (connection == null) {
                System.out.println("ERROR: Connection is null. The database connection could not be established.");
                return;
            }

            try (PreparedStatement stmt = connection.prepareStatement(sentence);
                 ResultSet rs = stmt.executeQuery()) {

                Printer.print(rs);
            }

        } catch (Exception e) {
            System.out.println("ERROR: The database operation has fail.");
            e.printStackTrace();
        }
    }

    /**
     * Para sentencias UPDATE/INSERT/DELETE.
     * Devuelve la cantidad de filas afectadas.
     */
    int executeUpdate() {
        try {
            Connection connection = ConnectionVault.get();
            if (connection == null) {
                System.out.println("ERROR: Connection is null. The database connection could not be established.");
                return 0;
            }

            try (PreparedStatement stmt = connection.prepareStatement(sentence)) {
                int rows = stmt.executeUpdate();
                return rows;
            }

        } catch (Exception e) {
            System.out.println("ERROR: The database operation has fail.");
            e.printStackTrace();
            return 0;
        }
    }
}
