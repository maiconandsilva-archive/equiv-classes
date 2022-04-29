package io.github.maiconandsilva.equivclasses.data.entities;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.maiconandsilva.equivclasses.utils.View;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
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
    @JsonView(View.ShortEquivalentClass.class)
    private Set<AcademicClass> academicClasses = new HashSet<>();

    public void registerEquivalentClass(AcademicClass academicClass) {
        academicClass.setEquivalentClass(this);
        academicClasses.add(academicClass);
    }

    public void removeEquivalentClass(AcademicClass academicClass) {
        academicClass.setEquivalentClass(null);
        academicClasses.remove(academicClass);
    }
}
