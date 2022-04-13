package io.github.maiconandsilva.equivclasses.entities;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Course extends AbstractPersistable<Long>  {
    private String name;
    private String period;
}
