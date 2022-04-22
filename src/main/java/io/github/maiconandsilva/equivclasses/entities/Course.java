package io.github.maiconandsilva.equivclasses.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.github.maiconandsilva.equivclasses.entities.enums.CoursePeriod;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AbstractPersistable<Long>  {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private CoursePeriod period;

    @OneToMany(mappedBy = "course")
    private Set<AcademicClass> academicClasses;
}
