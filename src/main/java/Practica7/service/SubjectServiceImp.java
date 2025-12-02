package Practica7.service;

import Practica7.model.Subject;
import Practica7.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubjectServiceImp implements SubjectService{

    private final SubjectRepository subjectRepository;


    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(Long id, Subject subject) {
        return subjectRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(subject.getNombre());
                    existing.setTeacher(subject.getTeacher());
                    return subjectRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }


}
