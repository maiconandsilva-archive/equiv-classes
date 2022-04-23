package io.github.maiconandsilva.equivclasses.data.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends AbstractPersistable<Long> implements GrantedAuthority {

    @NotNull
    @Column(unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
