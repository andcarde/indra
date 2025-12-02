package Practica7.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String identificacion;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}

