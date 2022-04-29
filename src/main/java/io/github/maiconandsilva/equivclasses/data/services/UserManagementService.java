package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserManagementService extends UserDetailsService {
    AcademicUser registerUser(AcademicUser academicUser, Long courseId);
}
