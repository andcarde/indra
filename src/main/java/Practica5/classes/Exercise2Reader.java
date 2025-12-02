package Practica5.classes;

public class Exercise2Reader {

    static Exercise2Printer exercise2Printer = new Exercise2Printer();

    static void int_pac1() {
        exercise2Printer.int_pac1();
    }

    static void act_int() {
        exercise2Printer.act_int();
    }

    static void int_pac2() {
        String localidad = "Capital";
        exercise2Printer.int_pac2(localidad);
    }

    static void a_pagar1() {
        String apellido = "Perez";
        Exercise2Printer.a_pagar1(apellido);
    }

    static void a_pagar2() {
        Exercise2Printer.a_pagar2();
    }
}
