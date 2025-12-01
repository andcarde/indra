package Practica1.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private ArrayList<Student> students;

    public Manager() {
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> cargarEstudiantes(){
        Scanner sc = new Scanner(System.in);
        String continuar = "s";
        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Nota: ");
            float nota = sc.nextFloat();
            System.out.println("Edad: ");
            int edad = sc.nextInt();
            if(edad<=0 || edad>=100){
                System.out.println("Edad no valida");
                edad = sc.nextInt();
            }
            sc.nextLine();

            students.add(new Student(nombre,nota,edad));

            System.out.print("¿Desea cargar otro estudiante? (s/n): ");
            continuar = sc.nextLine();

        }
        return students;
    }

    public void showAndfindByName(String name){
        for(Student e: students){
            if(e.getNombre().equalsIgnoreCase(name)){
                System.out.println(e.toString());
            }
        }
    }

    public void showAll(){
        for(Student e: students){
            System.out.println(e.toString());
        }
    }

    public void showGradeAverage(){
        float nota= 0;
        if(!students.isEmpty()) {
            for (Student e : students) {
                nota += e.getNota();
            }
            System.out.println(nota / students.size());
        } else System.out.println("No hay suficientes estudiantes");
    }
}

