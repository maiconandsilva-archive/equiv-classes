package io.github.maiconandsilva.equivclasses.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquivalentClass extends AbstractPersistable<Long> {
    @OneToMany(mappedBy = "equivalentClass")
    private Set<AcademicClass> academicClasses;
}
