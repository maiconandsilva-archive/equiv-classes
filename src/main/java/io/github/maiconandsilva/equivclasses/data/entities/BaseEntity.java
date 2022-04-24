package io.github.maiconandsilva.equivclasses.data.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
