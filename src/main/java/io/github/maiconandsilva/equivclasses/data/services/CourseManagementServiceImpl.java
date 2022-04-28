package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import io.github.maiconandsilva.equivclasses.data.entities.EquivalentClass;
import io.github.maiconandsilva.equivclasses.data.repositories.AcademicClassRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.CourseRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.EquivalentClassRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
    public EquivalentClass registerClassesEquivalency(Long equivalentClassId, Long ...classId) {
        EquivalentClass equivalentClass;

        if (equivalentClassId == null) {
            equivalentClass = new EquivalentClass();
        } else {
            equivalentClass = equivalentClassRepository.findById(equivalentClassId).orElseThrow();
        }

        for (AcademicClass ac: academicClassRepository.findAllById(Arrays.asList(classId))) {
            equivalentClass.registerEquivalentClass(ac);
        }
        return equivalentClassRepository.save(equivalentClass);
    }

    @Override
    public void removeClassesEquivalency(Long ...classId) {
        Iterable<AcademicClass> academicClasses =
                academicClassRepository.findAllById(Arrays.asList(classId));
        for (AcademicClass ac: academicClasses) {
            ac.getEquivalentClass().removeEquivalentClass(ac);
        }
        academicClassRepository.saveAll(academicClasses);
    }
}
