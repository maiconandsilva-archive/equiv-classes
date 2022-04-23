package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import io.github.maiconandsilva.equivclasses.data.entities.EquivalentClass;
import io.github.maiconandsilva.equivclasses.data.repositories.AcademicClassRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.CourseRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.EquivalentClassRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service("courseManagementService")
public class CourseManagementServiceImpl implements CourseManagementService {
    final AcademicClassRepository academicClassRepository;
    final CourseRepository courseRepository;
    final EquivalentClassRepository equivalentClassRepository;

    public CourseManagementServiceImpl(AcademicClassRepository academicClassRepository,
                                       CourseRepository courseRepository,
                                       EquivalentClassRepository equivalentClassRepository) {
        this.academicClassRepository = academicClassRepository;
        this.courseRepository = courseRepository;
        this.equivalentClassRepository = equivalentClassRepository;
    }

    @Override
    public Course createCourse(Course course) { // String code, String name) {
        return courseRepository.save(course);
    }

    @Override
    public AcademicClass registerClass(Long courseId, AcademicClass academicClass) {//String code, String name, Integer semester, Integer workload) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        academicClass.setCourse(course);
        return academicClassRepository.save(academicClass);
    }

    @Override
    public EquivalentClass registerClassesEquivalency(Long equivalentClassId, Long classId) {
        AcademicClass academicClass = academicClassRepository.findById(classId).orElseThrow(ValidationException::new);
        EquivalentClass equivalentClass = equivalentClassRepository.findById(equivalentClassId)
                                            .orElseGet(() -> equivalentClassRepository.save(new EquivalentClass()));
        academicClass.setEquivalentClass(equivalentClass);
        return equivalentClass;
    }

    @Override
    public void removeClassesEquivalency(Long classId) {
        AcademicClass academicClass = academicClassRepository.findById(classId).orElseThrow(ValidationException::new);
        academicClass.setEquivalentClass(null);
        academicClassRepository.save(academicClass);
    }
}
