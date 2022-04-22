package io.github.maiconandsilva.equivclasses.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Authority extends AbstractPersistable<Long> implements GrantedAuthority {

    @NotNull
    @Column(unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
