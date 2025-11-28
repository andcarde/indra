package Practica5.main;

import java.sql.SQLException;

public class Exercise1Reader {
    static Exercise1Printer exercise1Printer = new Exercise1Printer();

    public static void pac1() throws SQLException {
        exercise1Printer.pac1(1970);
    }
}
