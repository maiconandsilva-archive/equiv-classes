package io.github.maiconandsilva.equivclasses.services;

import io.github.maiconandsilva.equivclasses.entities.Authority;
import io.github.maiconandsilva.equivclasses.entities.Course;
import io.github.maiconandsilva.equivclasses.entities.User;
import io.github.maiconandsilva.equivclasses.repositories.CourseRepository;
import io.github.maiconandsilva.equivclasses.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Set;

@Service("userManagementService")
public class UserManagementServiceImpl implements UserManagement {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public UserManagementServiceImpl(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public User registerUser(String username, String password, Set<Authority> authorities, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(ValidationException::new);
        User user = new User(username, password, authorities, true, course);
        return userRepository.save(user);
    }
}
