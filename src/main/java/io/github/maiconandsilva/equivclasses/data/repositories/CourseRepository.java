package io.github.maiconandsilva.equivclasses.data.repositories;

import io.github.maiconandsilva.equivclasses.data.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Set<Course> findAllByNameIgnoreCaseContaining(String name);
}
