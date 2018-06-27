package com.rss.keshava.controller;

import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.Student;
import com.rss.keshava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Status create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping
    public Status update(@Valid @RequestBody Student student) {
        return studentService.update(student);
    }

    @GetMapping("/")
    public Iterable<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{uid}")
    public Student get(@PathVariable String uuid) {
        return studentService.getByUuid(uuid);
    }

    @DeleteMapping(value = "/{id}")
    public Status delete(@PathVariable String id) {
        return studentService.delete(id);
    }

}
