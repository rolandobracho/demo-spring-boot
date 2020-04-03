package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.service.CoursesService;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by rolando on 31-03-20.
 * http://localhost:8080/courses/?id=1
 */
@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @Autowired
    StudentsService studentsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity course(@PathVariable("id") Long id) throws IOException {
        Course course = coursesService.getCourse(id);

        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Student> getStudentsByCourse(@PathVariable("id") Long idCourse) throws IOException {
        return studentsService.findByCourseId(idCourse);
    }

    @GetMapping("/all")
    List<Course> findAll() { return coursesService.findAll();}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseEntity delete(@PathVariable("id") Long id) throws IOException {
        Course course = coursesService.getCourse(id);

        if (course == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        coursesService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseEntity update(@PathVariable("id") Long id, @RequestBody Course inCourse ) throws IOException {
        Course newCourse = coursesService.save(inCourse);
        return new ResponseEntity<Course>(newCourse, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity create(@RequestBody Course newCourse ) throws IOException {
        Course course = coursesService.save(newCourse);
        return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);
    }
}
