package io.github.maiconandsilva.equivclasses.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends AbstractPersistable<UUID> {
    private String username;
    private String password;
}
