package com.example.demo.repo;

import com.example.demo.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by rolando on 01-04-20.
 */
@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {

    List<Student> findByCourseId(Long id);
}
