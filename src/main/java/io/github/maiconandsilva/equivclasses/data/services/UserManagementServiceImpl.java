package io.github.maiconandsilva.equivclasses.data.services;

import io.github.maiconandsilva.equivclasses.data.entities.AcademicUser;
import io.github.maiconandsilva.equivclasses.data.entities.Course;
import io.github.maiconandsilva.equivclasses.data.repositories.AuthorityRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.CourseRepository;
import io.github.maiconandsilva.equivclasses.data.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service("userManagementService")
public class UserManagementServiceImpl implements UserManagementService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;

    public UserManagementServiceImpl(UserRepository userRepository,
                                     AuthorityRepository authorityRepository,
                                     CourseRepository courseRepository,
                                     PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.courseRepository = courseRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AcademicUser registerUser(AcademicUser user, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(ValidationException::new);
        user.setUsername(user.getUsername().toLowerCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getAuthorities().isEmpty()) {
            user.getAuthorities().add(authorityRepository.findByName("ROLE_USER"));
        }
        user.setCourse(course);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AcademicUser user = userRepository.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for username " + username);
        }
        return user;
    }
}
