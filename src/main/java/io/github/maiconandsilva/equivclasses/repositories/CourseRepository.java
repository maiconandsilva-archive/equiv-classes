package io.github.maiconandsilva.equivclasses.repositories;

import io.github.maiconandsilva.equivclasses.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByNameIgnoreCaseContaining(String name);
}
