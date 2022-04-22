package io.github.maiconandsilva.equivclasses.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AcademicClass extends AbstractPersistable<Long> {
    private String code;
    private String name;
    private Integer semester;
    private Integer workload;

    @ManyToOne(optional = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    private EquivalentClass equivalentClass;
}
