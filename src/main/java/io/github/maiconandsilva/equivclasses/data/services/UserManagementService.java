package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicUser;

public interface UserManagementService {
    AcademicUser registerUser(AcademicUser academicUser, Long courseId);
}
