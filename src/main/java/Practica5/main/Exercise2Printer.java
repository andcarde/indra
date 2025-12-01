package Practica5.main;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Exercise2Printer {
    private static final String URL  = "jdbc:mysql://localhost:3306/clinica";
    private static final String USER = "root";
    private static final String PASS = "root";

    public Exercise2Printer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

	static void int_pac1() {
    	SQLSentence sentence = new SQLSentence();
    	
    	sentence.add("SELECT ");
    	sentence.add("    i.numint,");
    	sentence.add("    i.codpac AS codpac_internacion,");
    	sentence.add("    p.codpac AS codpac_paciente,");
    	sentence.add("    p.apellido,");
    	sentence.add("    p.nombre,");
    	sentence.add("    p.localidad,");
    	sentence.add("    p.sexo");
    	sentence.add("FROM internacion i");
    	sentence.add("JOIN pacientes p ");
    	sentence.add("    ON i.codpac = p.codpac");
    	sentence.add("WHERE p.sexo = 'M'");
    	sentence.add("  AND p.codpac % 2 = 0;");

        sentence.execute();

        System.out.println("Update realizado correctamente.");
	}

	static void act_int() {
        SQLSentence sentence = new SQLSentence();

        sentence.add("UPDATE pacientes p");
        sentence.add("SET p.internado = CASE");
        sentence.add("    WHEN EXISTS (");
        sentence.add("        SELECT 1");
        sentence.add("        FROM internacion i");
        sentence.add("        WHERE i.codpac = p.codpac");
        sentence.add("          AND i.fecalt IS NULL");
        sentence.add("    ) THEN 1");
        sentence.add("    ELSE 0");
        sentence.add("END;");

        sentence.execute();
		
	}

    public void int_pac2(String localidad) {
        String sql =
                "SELECT i.NUMINT, " +
                        "       i.CODPAC AS CODPAC_INT, " +
                        "       p.CODPAC AS CODPAC_PAC, " +
                        "       p.APELLIDO, " +
                        "       p.NOMBRE, " +
                        "       p.LOCALIDAD, " +
                        "       p.SEXO " +
                        "FROM INTERNACION i " +
                        "JOIN PACIENTES p ON i.CODPAC = p.CODPAC " +
                        "WHERE p.SEXO = 'M' " +
                        "  AND p.CODPAC % 2 = 0 " +
                        "  AND p.LOCALIDAD = ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, localidad);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("NUMINT | CODPAC_INT | CODPAC_PAC | APELLIDO | NOMBRE | LOCALIDAD | SEXO");
                System.out.println("----------------------------------------------------------------------------");
                while (rs.next()) {
                    int numint    = rs.getInt("NUMINT");
                    int codInt    = rs.getInt("CODPAC_INT");
                    int codPac    = rs.getInt("CODPAC_PAC");
                    String ape    = rs.getString("APELLIDO");
                    String nom    = rs.getString("NOMBRE");
                    String loc    = rs.getString("LOCALIDAD");
                    String sexo   = rs.getString("SEXO");

                    System.out.println(numint + " | " + codInt + " | " + codPac + " | " +
                            ape + " | " + nom + " | " + loc + " | " + sexo);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en int_pac2: " + e.getMessage());
        }
    }

	static void a_pagar1() {
		
	}

	static void a_pagar2() {
		
	}
}
