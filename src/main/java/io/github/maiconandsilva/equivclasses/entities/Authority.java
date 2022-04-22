package io.github.maiconandsilva.equivclasses.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Authority extends AbstractPersistable<Long> implements GrantedAuthority {
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
