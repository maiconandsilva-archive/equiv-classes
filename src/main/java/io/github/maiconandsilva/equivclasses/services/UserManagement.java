package io.github.maiconandsilva.equivclasses.services;

import io.github.maiconandsilva.equivclasses.entities.Authority;
import io.github.maiconandsilva.equivclasses.entities.User;

import java.util.Set;

public interface UserManagement {
    User registerUser(String username, String password, Set<Authority> authorities, Long courseId);
}
