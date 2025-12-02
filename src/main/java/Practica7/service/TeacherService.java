package Practica7.service;

import Practica7.model.Teacher;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> getById(long id);

    List<Teacher> getAll();
    Teacher add(Teacher t);
    Teacher update(Long id,Teacher t);
    void delete (Long id);
}
