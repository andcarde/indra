package Practica1.Ejercicio1;

public class Student {
    private String nombre;
    private float nota;
    private int edad;

    public Student(String nombre, float nota, int edad) {
        this.nombre= nombre;
        this.nota=nota;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Nota: " + nota + ", Edad: " + edad + "\n";
    }

}
