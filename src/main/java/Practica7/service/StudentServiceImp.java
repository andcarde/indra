package Practica7.service;

import Practica7.model.Student;
import Practica7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> allStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student modifyStudent(Long id, Student s) {
        Student original = studentRepository.findById(id).orElse(null);
        if (original == null)
            return null;
        if (s.getNombre() != null)
            original.setNombre(s.getNombre());
        if (s.getApellido() != null)
            original.setApellido(s.getApellido());
        if (s.getIdentificacion() != null)
            original.setIdentificacion(s.getIdentificacion());
        return studentRepository.save(original);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null)
            studentRepository.delete(student);
    }
}
