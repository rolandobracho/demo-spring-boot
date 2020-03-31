package com.example.demo.repo;

import com.example.demo.domain.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by rolando on 31-03-20.
 */
@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepo extends PagingAndSortingRepository<Course, Long> {

//    @Query("SELECT DISTINCT c FROM Comite c JOIN c.agrupacion a JOIN a.privilegios p JOIN p.usuario u WHERE u.id = :usuarioId AND c.requiereRevision = true")
//    List<Course> findById(@Param("usuarioId") Long usuarioId);
}
