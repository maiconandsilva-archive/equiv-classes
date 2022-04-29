package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import io.github.maiconandsilva.equivclasses.data.entities.EquivalentClass;

public interface AcademicClassManagementService {
    Course createCourse(Course course);
    AcademicClass registerClass(Long courseId, AcademicClass academicClass);
    EquivalentClass registerClassesEquivalency(Long equivalentClassId, Long ...classId);
    void removeClassesEquivalency(Long ...classId);
}
