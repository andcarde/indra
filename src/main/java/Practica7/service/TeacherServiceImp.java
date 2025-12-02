package Practica7.service;

import Practica7.model.Subject;
import Practica7.model.Teacher;
import Practica7.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Optional<Teacher> getById(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher add(Teacher t) {
        return teacherRepository.save(t);
    }

    @Override
    public Teacher update(Long id, Teacher t) {
        return teacherRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(t.getNombre());
                    return teacherRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }


    @Override
    public void delete(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacherRepository.delete(teacher);
        }
    }
}
