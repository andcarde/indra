package Practica7.service;

import Practica7.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAll();
    Optional<Subject> getById(Long id);
    Subject create(Subject subject);
    Subject update(Long id, Subject subject);
    void delete(Long id);

}
