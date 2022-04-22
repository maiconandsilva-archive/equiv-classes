package io.github.maiconandsilva.equivclasses.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Course extends AbstractPersistable<Long>  {
    private String name;
    private String period;

    @OneToMany(mappedBy = "course")
    private Set<AcademicClass> academicClasses;
}
