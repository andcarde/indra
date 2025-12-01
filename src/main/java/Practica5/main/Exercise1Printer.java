package Practica5.main;

import java.sql.*;

public class Exercise1Printer {
  private static final String URL  = "jdbc:mysql://localhost:3306/clinica";
    private static final String USER = "root";
    private static final String PASS = "root";

    public Exercise1Printer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }



    public void pac1 (int anio) throws SQLException {
        String sql = "SELECT CODPAC, APELLIDO, NOMBRE, CODOSO, FECNAC" + " FROM PACIENTES WHERE YEAR(FECNAC) < ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, anio);

            try (ResultSet rs = ps.executeQuery()){
                System.out.println("CODPAC | APELLIDO | NOMBRE | CODOSO | FECNAC");
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int codpac = rs.getInt("CODPAC");
                    String apellido = rs.getString("APELLIDO");
                    String nombre = rs.getString("NOMBRE");
                    int codoso = rs.getInt("CODOSO");
                    Date fechac = rs.getDate("FECNAC");

                    System.out.println(codpac + "|" + apellido + "|" + nombre + "|" + codoso + "|" + fechac);
                }
            }

        }catch (SQLException e) {
            System.out.println("Error en pac1: " + e.getMessage());
        }
    }


    public void pac2 (String letra, int edadMin){
        String sql = "SELECT CODPAC, APELLIDO, NOMBRE, CODOSO, FECNAC" + " FROM PACIENTES WHERE APELLIDO LIKE ?" + " AND TIMESTAMPDIFF(YEAR, FECNAC, CURDATE()) > ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, letra + "%");
            ps.setInt(2, edadMin);

            try (ResultSet rs = ps.executeQuery()){
                System.out.println("CODPAC | APELLIDO | NOMBRE | CODOSO | FECNAC");
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int codpac = rs.getInt("CODPAC");
                    String apellido = rs.getString("APELLIDO");
                    String nombre = rs.getString("NOMBRE");
                    int codoso = rs.getInt("CODOSO");
                    Date fechac = rs.getDate("FECNAC");

                    System.out.println(codpac + "|" + apellido + "|" + nombre + "|" + codoso + "|" + fechac);
                }
            }

        }catch (SQLException e) {
            System.out.println("Error en pac2: " + e.getMessage());
        }
    }

    public void pac3a (int codOS){
        String sql = "SELECT CODPAC, APELLIDO, NOMBRE, CODOSO, FECNAC" + " FROM PACIENTES WHERE CODOSO > ? " + "AND SEXO = 'M' OR LOCALIDAD = 'Capital'";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, codOS);

            try (ResultSet rs = ps.executeQuery()){
                System.out.println("CODPAC | APELLIDO | NOMBRE | CODOSO | FECNAC");
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int codpac = rs.getInt("CODPAC");
                    String apellido = rs.getString("APELLIDO");
                    String nombre = rs.getString("NOMBRE");
                    int codoso = rs.getInt("CODOSO");
                    Date fechac = rs.getDate("FECNAC");

                    System.out.println(codpac + "|" + apellido + "|" + nombre + "|" + codoso + "|" + fechac);
                }
            }

        }catch (SQLException e) {
            System.out.println("Error en pac3a: " + e.getMessage());
        }
    }
    public void pac3b(int codOS){
        String sql = "SELECT CODPAC, APELLIDO, NOMBRE, CODOSO, FECNAC" + " FROM PACIENTES WHERE CODOSO > ? " + "AND (SEXO = 'M' OR LOCALIDAD = 'Capital')";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, codOS);

            try (ResultSet rs = ps.executeQuery()){
                System.out.println("CODPAC | APELLIDO | NOMBRE | CODOSO | FECNAC");
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int codpac = rs.getInt("CODPAC");
                    String apellido = rs.getString("APELLIDO");
                    String nombre = rs.getString("NOMBRE");
                    int codoso = rs.getInt("CODOSO");
                    Date fechac = rs.getDate("FECNAC");

                    System.out.println(codpac + "|" + apellido + "|" + nombre + "|" + codoso + "|" + fechac);
                }
            }

        }catch (SQLException e) {
            System.out.println("Error en pac3b: " + e.getMessage());
        }
    }
    public void paxcos(){
        String sql = "SELECT CODOSO, COUNT(*) AS CANTIDAD" + " FROM PACIENTES " + "GROUP BY CODOSO" + " ORDER BY codoso asc";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){

            try (ResultSet rs = ps.executeQuery()){
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int codoso = rs.getInt("CODOSO");
                    int cantidad = rs.getInt("CANTIDAD");

                    System.out.println("CODOSO: " +codoso + "|" + "CANTIDAD: "+ cantidad);
                }
            }

        }catch (SQLException e) {
            System.out.println("Error en paxos: " + e.getMessage());
        }
    }

    public void promXos (){
        String sql = "SELECT CODOSO, " + " COUNT(*) AS CANTIDAD, " + " AVG(TIMESTAMPDIFF(YEAR, FECNAC, CURDATE())) AS AVG, " +
                        " SUM(TIMESTAMPDIFF(YEAR, FECNAC, CURDATE())) / COUNT(*) AS PROMEDIO " + "FROM PACIENTES " +
                        "GROUP BY CODOSO " + "ORDER BY CODOSO ASC";


        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){

            try (ResultSet rs = ps.executeQuery()){
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int codoso = rs.getInt("CODOSO");
                    int cantidad = rs.getInt("CANTIDAD");
                    double avg = rs.getDouble("AVG");
                    double pro = rs.getDouble("PROMEDIO");
                    System.out.println("CODOSO: " +codoso + " | " + "CANTIDAD: "+ cantidad + " | " + "AVG: "+ avg + " | " + "PROMEDIO: "+ pro);
                }
            }

        }catch (SQLException e) {
            System.out.println("Error en paxos: " + e.getMessage());
        }
    }

    public void mod_pre(){
        String sql = "UPDATE PRECIOS" + " SET PRECIO = ROUND(PRECIO * 1.05)" + " WHERE CLASEH IN ('A', 'B')";


        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            int filas = ps.executeUpdate();
            System.out.println("PRECIOS modificado con sucesso! Filas afectadas: " + filas);

        }catch (SQLException e) {
            System.out.println("Error en mod_pre: " + e.getMessage());
        }
    }

    public void prom_mes () {
        String sql = "SELECT YEAR(FECINT) AS ANIO, MONTH(FECINT) AS MES, AVG(DATEDIFF(IFNULL(FECALT,CURDATE()),FECINT)) AS PROM_DIAS " +
                "FROM INTERNACION WHERE  CLASEH IN ('A', 'B') GROUP BY YEAR(FECINT), MONTH(FECINT)" +
                "HAVING PROM_DIAS >15 ORDER BY MES";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int anio = rs.getInt("ANIO");
                    int mes = rs.getInt("MES");
                    double avg = rs.getDouble("PROM_DIAS");
                    System.out.println("ANIO: " +anio + " | " + "MES: "+ mes + " | " + "Promedio Dias: "+ avg );
                }
            }
        }catch (SQLException e) {
            System.out.println("Error en paxos: " + e.getMessage());
        }

    }

    public void est_alta () {
        String sql = "SELECT NUMINT, CODPAC, EST_ALTA, FECALT, DATEDIFF(FECALT, EST_ALTA) AS DIFERENCIA,"+
                " IF (DATEDIFF(FECALT, EST_ALTA) < '0', 'OK', 'REVISAR') AS OBSERVACIONES" +
                " FROM INTERNACION WHERE FECALT IS NOT NULL";

        /*
        SELECT numint, codpac, est_alta, fecalt, 
            TIMESTAMPDIFF(DAY, est_alta, fecalt) AS diferencia, 
            CASE WHEN 
            TIMESTAMPDIFF(DAY, est_alta, fecalt) > 0 THEN 'REVISAR' ELSE 'OK' END AS OBSERVACIONES 
            FROM clinica.internacion WHERE fecalt IS NOT NULL;
         */
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                System.out.println("--------------------------------------------");
                while (rs.next()){
                    int numint = rs.getInt("NUMINT");
                    int codpac = rs.getInt("CODPAC");
                    Date estalta = rs.getDate("EST_ALTA");
                    Date fecalt = rs.getDate("FECALT");
                    int diferencia = rs.getInt("DIFERENCIA");
                    String observaciones = rs.getString("OBSERVACIONES");

                    System.out.println("NUMINT: " + numint + " | " + "CODPAC: " + codpac + " | " + "EST_ALTA: " + estalta + " | " + "FECALT: " + fecalt + " | " + "DIFERENCIA: " + diferencia +" | "+  "OBSERVACIONES: " + observaciones);
                }
            }
        }catch (SQLException e) {
            System.out.println("Error en paxos: " + e.getMessage());
        }
    }
}
