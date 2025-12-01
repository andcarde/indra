package Practica5.main;

import java.sql.SQLException;

public class Exercise1Reader {
    static Exercise1Printer exercise1Printer = new Exercise1Printer();

    public static void pac1() throws SQLException {
        exercise1Printer.pac1(1970);
    }

    public static void pac2() {
        exercise1Printer.pac2("V",50);
    }

    public static void pac3a() {
        exercise1Printer.pac3a(3);
    }

    public static void pac3b() {
        exercise1Printer.pac3b(3);
    }

    public static void pacxos() {
        exercise1Printer.paxcos();
    }

    public static void promXos() {
        exercise1Printer.promXos();
    }

    public static void mod_pre() {
        exercise1Printer.mod_pre();
    }

    public static void prom_mes() {
        exercise1Printer.prom_mes();
    }

    public static void est_alta() {
        exercise1Printer.est_alta();
    }
}
