package io.github.maiconandsilva.equivclasses.repositories;

import io.github.maiconandsilva.equivclasses.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findByUsername(String username);
}
