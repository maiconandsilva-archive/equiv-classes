package io.github.maiconandsilva.equivclasses.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicClass extends AbstractPersistable<Long> {
    private String code;

    @NotNull
    @NotBlank
    private String name;

    @Min(1)
    @NotNull
    private Integer semester;

    /**
     * Course duration for the semester
     * Workload in hours
     */
    @Min(1)
    private Integer workload;

    @ManyToOne(optional = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    private EquivalentClass equivalentClass;
}
