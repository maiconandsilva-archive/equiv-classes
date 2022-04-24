package io.github.maiconandsilva.equivclasses.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquivalentClass extends BaseEntity<Long> {
    @OneToMany(
        mappedBy = "equivalentClass",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private Set<AcademicClass> academicClasses;
}
