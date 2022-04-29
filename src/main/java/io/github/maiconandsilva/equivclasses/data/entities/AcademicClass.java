package io.github.maiconandsilva.equivclasses.data.entities;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.maiconandsilva.equivclasses.utils.View;
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
    @JsonView(View.Short.class)
    private String code;

    @NotNull
    @NotBlank
    @JsonView(View.Short.class)
    private String name;

    @Min(1)
    @JsonView(View.Short.class)
    private Integer semester;

    /**
     * Course duration for the semester
     * Workload in hours
     */
    @Min(1)
    @JsonView(View.Short.class)
    private Integer workload;

    @ManyToOne(optional = false)
    @JsonView(View.Short.class)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(View.Extended.class)
    private EquivalentClass equivalentClass;
}
