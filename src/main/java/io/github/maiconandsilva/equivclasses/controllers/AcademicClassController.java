package io.github.maiconandsilva.equivclasses.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.maiconandsilva.equivclasses.data.entities.AcademicClass;
import io.github.maiconandsilva.equivclasses.data.entities.EquivalentClass;
import io.github.maiconandsilva.equivclasses.data.repositories.AcademicClassRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.CourseRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.EquivalentClassRepository;
import io.github.maiconandsilva.equivclasses.utils.View;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static io.github.maiconandsilva.equivclasses.utils.requests.RequestErrorHandler.getOr404;

@RestController
@RequestMapping(value = "/classes")
@CrossOrigin
public class AcademicClassController {
    final AcademicClassRepository academicClassRepository;
    final CourseRepository courseRepository;
    final EquivalentClassRepository equivalentClassRepository;

    public AcademicClassController(AcademicClassRepository academicClassRepository,
                                   CourseRepository courseRepository,
                                   EquivalentClassRepository equivalentClassRepository) {
        this.academicClassRepository = academicClassRepository;
        this.courseRepository = courseRepository;
        this.equivalentClassRepository = equivalentClassRepository;
    }

    @GetMapping(path = "")
    @JsonView(View.Extended.class)
    public Iterable<AcademicClass> search(
            @RequestParam(value = "s", required = false) String search) {
        if (search == null) {
            return academicClassRepository.findAll();
        }
        return academicClassRepository.search(search);
    }

    @GetMapping(path = "/{id}")
    @JsonView(View.Extended.class)
    public AcademicClass getById(@PathVariable Long id) {
        return academicClassRepository.findById(id).orElseThrow();
    }

    @GetMapping(path = "/equivalents/class/{classId}")
    @JsonView(View.Short.class)
    public Set<AcademicClass> equivalentClassesFromClass(@PathVariable Long classId) {
        return academicClassRepository.findAllEquivalentsByAcademicClassId(classId);
    }

    @GetMapping(path = "/equivalents/{equivId}")
    @JsonView(View.ShortEquivalentClass.class)
    public EquivalentClass equivalentClasses(@PathVariable Long equivId) {
        return getOr404(equivalentClassRepository.findById(equivId));
    }
}
