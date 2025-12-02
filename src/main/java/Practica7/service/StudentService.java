package Practica7.service;

import Practica7.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> allStudent();
    Student createStudent(Student student);
    Optional<Student> getStudent(Long id);
    void deleteStudent(Long id);
    Student modifyStudent(Long id, Student student);
}
