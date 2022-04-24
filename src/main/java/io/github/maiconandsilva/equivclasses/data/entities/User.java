package io.github.maiconandsilva.equivclasses.data.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractPersistable<UUID> implements UserDetails {

    @NotNull
    @Size(min = 6, max = 16)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @ManyToMany
    private Set<Authority> authorities;

    private boolean active = true;

    @OneToOne(fetch = FetchType.LAZY)
    private Course course;

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
