package io.github.maiconandsilva.equivclasses.data.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquivalentClass extends AbstractPersistable<Long> {
    @OneToMany(
        mappedBy = "equivalentClass",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private Set<AcademicClass> academicClasses;
}
