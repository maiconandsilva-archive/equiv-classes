package io.github.maiconandsilva.equivclasses.data.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.maiconandsilva.equivclasses.utils.View;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {
    @Override
    @JsonProperty
    @JsonView(View.Minimal.class)
    public ID getId() {
        return super.getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
