package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.Authority;
import io.github.maiconandsilva.equivclasses.data.entities.User;

import java.util.Set;

public interface UserManagement {
    User registerUser(String username, String password, Set<Authority> authorities, Long courseId);
}
