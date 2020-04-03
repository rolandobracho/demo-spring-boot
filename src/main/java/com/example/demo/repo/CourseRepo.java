package com.example.demo.repo;

import com.example.demo.domain.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by rolando on 31-03-20.
 */
@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepo extends PagingAndSortingRepository<Course, Long> {

}
