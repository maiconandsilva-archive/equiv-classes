package io.github.maiconandsilva.equivclasses.data.repositories;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AcademicClassRepository extends CrudRepository<AcademicClass, Long> {
    Set<AcademicClass> findAllByNameIgnoreCaseContaining(String name);
    Set<AcademicClass> findAllByCodeIgnoreCaseContaining(String code);
    Set<AcademicClass> findAllByCourse(Course course);
}
