package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repo.StudentRepo;
import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by rolando on 01-04-20.
 */
@Configurable
@Service
public class StudentsService {
    private Logger logger = LoggerFactory.getLogger(StudentsService.class);

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    ServletContext servletContext;

    public Student getStudent(Long id) throws IOException {
        return studentRepo.findOne(id);
    }

    public List<Student> findAll() {
        List<Student> students = IteratorUtils.toList(studentRepo.findAll().iterator());
        return students;
    }

    public void delete(Long id) {
        studentRepo.delete(id);
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> findByCourseId(Long id){
        List<Student> students = IteratorUtils.toList(studentRepo.findByCourseId(id).iterator());
        return students;
    }
}
