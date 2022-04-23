package io.github.maiconandsilva.equivclasses.data.repositories;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.EquivalentClass;
import org.springframework.data.repository.CrudRepository;

public interface EquivalentClassRepository extends CrudRepository<EquivalentClass, Long> {
    EquivalentClass findByAcademicClassesContains(AcademicClass academicClass);
}
