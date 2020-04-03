package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by rolando on 01-04-20.
 * http://localhost:8080/students/id/1
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentsService studentsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity student(@PathVariable("id") Long id) throws IOException {
        Student student = studentsService.getStudent(id);

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/all")
    List<Student> findAll() {
        return studentsService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseEntity delete(@PathVariable("id") Long id) throws IOException {
        Student student = studentsService.getStudent(id);

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        studentsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseEntity update(@PathVariable("id") Long id, @RequestBody Student inStudent ) throws IOException {
        Student newStudent = studentsService.save(inStudent);
        return new ResponseEntity<Student>(newStudent, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity create(@RequestBody Student newStudent ) throws IOException {
        Student student = studentsService.save(newStudent);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }
}
