package io.github.maiconandsilva.equivclasses.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicClass extends BaseEntity<Long> {

    @NotBlank
    private String code;

    @NotNull
    @NotBlank
    private String name;

    @Min(1)
    private Integer semester;

    /**
     * Course duration for the semester
     * Workload in hours
     */
    @Min(1)
    private Integer workload;

    @ManyToOne(optional = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    private EquivalentClass equivalentClass;
}
