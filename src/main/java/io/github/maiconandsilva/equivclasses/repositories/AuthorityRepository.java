package io.github.maiconandsilva.equivclasses.repositories;

import io.github.maiconandsilva.equivclasses.entities.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Authority findByName(String name);
}
