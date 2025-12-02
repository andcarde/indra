package Practica7.controller;


import Practica7.model.Subject;
import Practica7.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Subject> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return service.create(subject);
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject subject) {
        return service.update(id, subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

