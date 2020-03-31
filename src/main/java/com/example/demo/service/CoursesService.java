package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repo.CourseRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;

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

    public String getCourse(Long idCourse) throws IOException {
        Course course = courseRepo.findOne(idCourse);
        return course.getName();
    }


}
