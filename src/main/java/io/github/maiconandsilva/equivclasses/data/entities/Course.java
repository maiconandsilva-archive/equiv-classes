package io.github.maiconandsilva.equivclasses.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity<Long> {

    @NotNull
    @NotBlank
    private String code;

    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "course")
    private Set<AcademicClass> academicClasses = new HashSet<>();
}
