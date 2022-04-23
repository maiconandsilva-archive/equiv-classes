package io.github.maiconandsilva.equivclasses.data.repositories;

import io.github.maiconandsilva.equivclasses.data.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByNameIgnoreCaseContaining(String name);
}
