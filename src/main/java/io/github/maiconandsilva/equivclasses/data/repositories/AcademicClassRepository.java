package io.github.maiconandsilva.equivclasses.data.repositories;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AcademicClassRepository extends CrudRepository<AcademicClass, Long> {
    @Query("from AcademicClass ac"
            + " where lower(ac.name) like concat('%', lower(?1), '%')"
            + " or lower(ac.code) like concat('%', lower(?1), '%')"
            + " or lower(ac.course.name) like concat('%', lower(?1), '%')"
            + " or lower(ac.course.code) like concat('%', lower(?1), '%')"
    )
    Set<AcademicClass> search(String search);

    @Query("from AcademicClass ac where ac.equivalentClass.id = ("
         + "select ac1.equivalentClass.id from AcademicClass ac1 where ac1.id = ?1)"
    )
    Set<AcademicClass> findAllEquivalentsByAcademicClassId(Long academicClassId);

    Set<AcademicClass> findAllByNameIgnoreCaseContaining(String name);
    Set<AcademicClass> findAllByCodeIgnoreCaseContaining(String code);
    Set<AcademicClass> findAllByCourse(Course course);
}
