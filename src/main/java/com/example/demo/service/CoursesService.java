package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repo.CourseRepo;
import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;

/**
 * Created by rolando on 07-10-16.
 */
@Configurable
@Service
public class CoursesService {
    private Logger logger = LoggerFactory.getLogger(CoursesService.class);

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    ServletContext servletContext;

    public Course getCourse(Long idCourse) throws IOException {
        return courseRepo.findOne(idCourse);
    }

    public List<Course> findAll() {
        List<Course> courses = IteratorUtils.toList(courseRepo.findAll().iterator());
        return courses;
    }

    public void delete(Long id) {
        courseRepo.delete(id);
    }

    public Course save(Course course) {
        return courseRepo.save(course);
    }
}
