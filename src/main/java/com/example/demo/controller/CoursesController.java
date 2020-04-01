package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.service.CoursesService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity course(@RequestParam("id") Long idCourse) throws IOException {
        String nombre = coursesService.getCourse(idCourse);
        return new ResponseEntity<>("Your idCourse is " + nombre, HttpStatus.OK);
    }

    @GetMapping("/all")
    List<Course> findAll() {
        return coursesService.findAll();
    }
}
