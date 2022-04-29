package io.github.maiconandsilva.equivclasses.data.entities;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.maiconandsilva.equivclasses.utils.View;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicUser extends BaseEntity<UUID> implements UserDetails {

    @NotNull
    @Size(min = 6, max = 16)
    @Column(unique = true)
    @JsonView(View.Short.class)
    private String username = "";

    @NotNull
    @NotBlank
    private String password;

    @ManyToMany
    private Set<Authority> authorities = new HashSet<>();

    @JsonView(View.Short.class)
    private boolean active = true;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonView(View.Extended.class)
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
