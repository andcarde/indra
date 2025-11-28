package Practica1.Ejercicio1;

import java.util.Scanner;

public class Menu {

    private static void showOptions() {
        String options = "0. Mostrar todos \n";
        options += "1. Promedio de notas \n";
        options += "2. Buscar por nombre \n";
        options += "3. Salir \n";
        System.out.println(options);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        manager.cargarEstudiantes();
        while(true) {
            Menu.showOptions();
            try {
                int option = sc.nextInt();
                sc.nextLine();
                switch(option) {
                    case 0:
                        manager.showAll();
                        break;
                    case 1:

                        manager.showGradeAverage();
                        break;
                    case 2:
                        System.out.println("Name: ");
                        String name = sc.nextLine();
                        manager.showAndfindByName(name);
                        break;
                    case 3:
                        sc.close();
                        return;
                }
            } catch (Exception e) {
                System.out.println("WARNING: The option number is Invalid");
            }
        }
    }
}
