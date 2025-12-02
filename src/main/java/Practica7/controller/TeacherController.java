package Practica7.controller;

import Practica7.model.Teacher;
import Practica7.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;


    @GetMapping("/list")  //http://localhost:8080/empleados/listado
    public List<Teacher> getAllTeachers(){
        return teacherService.getAll();
    }

    @GetMapping(path="/id/{id1}")
    public Optional<Teacher> getTeacherById(@PathVariable long id1) {
        return teacherService.getById(id1);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher t) {
        return teacherService.add(t);
    }

    @PutMapping(path="/{id1}")
    public Teacher updateTeacher(@PathVariable long id1,@RequestBody Teacher t) {
        t.setId(id1);
        return teacherService.update(id1, t);
    }

    @DeleteMapping(path="/delete/{id1}") //http://localhost:8080/empleados/delete/2
    public void deleteTeacher(@PathVariable long id1) {
        teacherService.delete(id1);
    }

}
