package io.github.maiconandsilva.equivclasses.repositories;

import io.github.maiconandsilva.equivclasses.entities.AcademicClass;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AcademicClassRepository extends CrudRepository<AcademicClass, Long> {
    Set<AcademicClass> findByNameIgnoreCaseContainingOrCodeIgnoreCaseContaining(String name, String code);
    AcademicClass findByCourseId(Long courseId);
}
