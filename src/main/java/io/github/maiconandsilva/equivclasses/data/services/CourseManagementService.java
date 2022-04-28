package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import io.github.maiconandsilva.equivclasses.data.entities.EquivalentClass;

public interface CourseManagementService {
    Course createCourse(Course course); // String code, String name);
    AcademicClass registerClass(Long courseId, AcademicClass academicClass); //String code, String name, Integer semester, Integer workload);
    EquivalentClass registerClassesEquivalency(Long equivalentClassId, Long ...classId);
    void removeClassesEquivalency(Long ...classId);
}
