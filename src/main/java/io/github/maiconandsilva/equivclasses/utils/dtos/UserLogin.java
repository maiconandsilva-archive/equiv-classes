package io.github.maiconandsilva.equivclasses.utils.dtos;

import io.github.maiconandsilva.equivclasses.data.entities.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
    private String username;
    private String password;
    private Set<Authority> authorities = new HashSet<>();

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
