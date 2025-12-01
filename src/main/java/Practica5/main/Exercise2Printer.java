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

    private static Connection getConnection() throws SQLException {
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

                    System.out.println(numint + " | " + codInt + " | " + codPac + " | " + ape + " | " + nom + " | " + loc + " | " + sexo);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en int_pac2: " + e.getMessage());
        }
    }

	static void a_pagar1(String apellido) {
        String sql =
                "SELECT " +
                        "    p.apellido, " +
                        "    p.nombre, " +
                        "    o.nomoso AS obra_social, " +
                        "    i.habitacion, " +
                        "    DATEDIFF(i.fecalt, i.fecint) AS dias_internacion, " +
                        "    DATEDIFF(i.fecalt, i.fecint) * pr.precio AS costo_int_bruto, " +
                        "    o.des_int, " +
                        "    i.remedios AS remedios_brutos, " +
                        "    o.des_rem, " +
                        "    (DATEDIFF(i.fecalt, i.fecint) * pr.precio) * (1 - o.des_int / 100.0) " +
                        "      + i.remedios * (1 - o.des_rem / 100.0) AS total_pagar " +
                        "FROM pacientes p " +
                        "JOIN internacion i ON i.codpac  = p.codpac " +
                        "JOIN precios    pr ON pr.claseh = i.claseh " +
                        "JOIN obraso o  ON o.codoso = p.codoso " +
                        "WHERE p.apellido = ?";

        try {
            Connection con = ConnectionVault.get();              // NO se cierra
            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, apellido);

                try (ResultSet rs = ps.executeQuery()) {
                    System.out.println("APELLIDO | NOMBRE | OBRA_SOCIAL | HAB | DIAS_INT | COSTO_INT_BRUTO | DES_INT | REM_BRUTO | DES_REM | TOTAL");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------");
                    while (rs.next()) {
                        String ape        = rs.getString("apellido");
                        String nom        = rs.getString("nombre");
                        String obra       = rs.getString("obra_social");
                        String hab        = rs.getString("habitacion");
                        int dias          = rs.getInt("dias_internacion");
                        double costoBruto = rs.getDouble("costo_int_bruto");
                        double desInt     = rs.getDouble("des_int");
                        double remBruto   = rs.getDouble("remedios_brutos");
                        double desRem     = rs.getDouble("des_rem");
                        double total      = rs.getDouble("total_pagar");

                        System.out.println(
                                ape + " | " + nom + " | " + obra + " | " + hab + " | " +
                                        dias + " | " + costoBruto + " | " + desInt + " | " +
                                        remBruto + " | " + desRem + " | " + total
                        );
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR en a_pagar1: " + e.getMessage());
            e.printStackTrace();
        }
	}

	static void a_pagar2() {
        String sql =
                "SELECT " +
                        "    i.est_alta AS estimacion_alta, " +
                        "    p.apellido, " +
                        "    p.nombre, " +
                        "    DATEDIFF(i.est_alta, i.fecint) AS dias_internacion, " +
                        "    DATEDIFF(i.est_alta, i.fecint) * pr.precio AS costo_int_bruto, " +
                        "    o.des_int, " +
                        "    i.remedios AS remedios_brutos, " +
                        "    o.des_rem, " +
                        "    (DATEDIFF(i.est_alta, i.fecint) * pr.precio) * (1 - o.des_int / 100.0) " +
                        "      + i.remedios * (1 - o.des_rem / 100.0) AS total_pagar " +
                        "FROM internacion i " +
                        "JOIN pacientes  p ON p.codpac  = i.codpac " +
                        "JOIN precios    pr ON pr.claseh = i.claseh " +
                        "JOIN obraso o  ON o.codoso = p.codoso " +
                        "WHERE i.fecalt IS NULL";

        try {
            Connection con = ConnectionVault.get();
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("EST_ALTA | APELLIDO | NOMBRE | DIAS_INT | COSTO_INT_BRUTO | DES_INT | REM_BRUTO | DES_REM | TOTAL");
                System.out.println("---------------------------------------------------------------------------------------------------");
                while (rs.next()) {
                    java.sql.Date estAlta = rs.getDate("estimacion_alta");
                    String ape           = rs.getString("apellido");
                    String nom           = rs.getString("nombre");
                    int dias             = rs.getInt("dias_internacion");
                    double costoBruto    = rs.getDouble("costo_int_bruto");
                    double desInt        = rs.getDouble("des_int");
                    double remBruto      = rs.getDouble("remedios_brutos");
                    double desRem        = rs.getDouble("des_rem");
                    double total         = rs.getDouble("total_pagar");

                    System.out.println(
                            estAlta + " | " + ape + " | " + nom + " | " +
                                    dias + " | " + costoBruto + " | " + desInt + " | " +
                                    remBruto + " | " + desRem + " | " + total
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR en a_pagar2: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
