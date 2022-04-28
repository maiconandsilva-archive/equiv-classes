package io.github.maiconandsilva.equivclasses.data.repositories;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<AcademicUser, UUID> {
    AcademicUser findByUsernameIgnoreCase(String username);
}
