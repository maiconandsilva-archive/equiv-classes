package io.github.maiconandsilva.equivclasses.entities;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class ClassInfo extends AbstractPersistable<Long> {
    private String code;
    private String name;
    private LocalTime time;

    @ManyToOne
    private Course course;

    @ManyToMany
    private Set<ClassInfo> equivalentClasses;
}
