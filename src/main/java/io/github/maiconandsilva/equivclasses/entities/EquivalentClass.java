package io.github.maiconandsilva.equivclasses.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class EquivalentClass extends AbstractPersistable<Long> {
    @OneToMany(mappedBy = "equivalentClass")
    private Set<AcademicClass> academicClasses;
}
