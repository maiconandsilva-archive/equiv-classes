package io.github.maiconandsilva.equivclasses;

import io.github.maiconandsilva.equivclasses.data.entities.*;
import io.github.maiconandsilva.equivclasses.data.repositories.*;
import io.github.maiconandsilva.equivclasses.data.services.AcademicClassManagementService;
import io.github.maiconandsilva.equivclasses.data.services.UserManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Rollback
@Transactional
@SpringBootTest
class EquivClassesApplicationTests {

    @Autowired
    AcademicClassManagementService academicClassManagementService;

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AcademicClassRepository academicClassRepository;

    @Autowired
    EquivalentClassRepository equivalentClassRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

	@Test
	void contextLoads() {

	}

	@Test
    @WithMockUser(roles = "ADMIN")
    void courseCreationTest() {
	    Course course = new Course();
	    course.setName("Repository Test");
	    course.setCode("RPTT-1");

	    Course course1 = new Course();
	    course1.setName("Test Repository");
	    course1.setCode("TTRP-2");

        academicClassManagementService.createCourse(course);
        academicClassManagementService.createCourse(course1);

        Assertions.assertNotNull(course.getId());
        Assertions.assertNotNull(course1.getId());

        Set<Course> courses = courseRepository.findAllByNameIgnoreCaseContaining("Test");
        Assertions.assertEquals(2, courses.size());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void userCreationTest() {
	    Course course = courseRepository.findById(1L).orElseThrow();

	    AcademicUser user = new AcademicUser();
        user.setUsername("USER_TEST");
        user.setPassword("0123456789");
        user.setCourse(course);
        Authority admin = authorityRepository.findByName("ROLE_ADMIN");
        user.getAuthorities().add(admin);

        userManagementService.registerUser(user, 1L);

        Assertions.assertNotNull(user.getId());

        Authority authority = (Authority) user.getAuthorities().toArray()[0];

        Assertions.assertEquals(authority.getId(), admin.getId());

        AcademicUser foundUser = userRepository.findByUsernameIgnoreCase("USER_TEST");
        Assertions.assertNotNull(foundUser);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void academicClassCreationTest() {
        int courseClassesNumBefore = academicClassRepository.findAllByCourse(
                courseRepository.findById(1L).orElseThrow()).size();

        AcademicClass academicClass = new AcademicClass();
        academicClass.setName("First");
        academicClass.setCode("TTTCF1");
        academicClass.setSemester(1);
        academicClass.setWorkload(80);

        AcademicClass academicClass2 = new AcademicClass();
        academicClass2.setName("Second");
        academicClass2.setCode("TTTCS2");
        academicClass2.setSemester(1);
        academicClass2.setWorkload(80);

        academicClassManagementService.registerClass(1L, academicClass);
        academicClassManagementService.registerClass(1L, academicClass2);

        Assertions.assertNotNull(academicClass.getId());
        Assertions.assertNotNull(academicClass2.getId());

        academicClassManagementService.registerClassesEquivalency(
                null, academicClass.getId(), academicClass2.getId());

        EquivalentClass eq = equivalentClassRepository.findByAcademicClassesContains(academicClass2);

        Assertions.assertEquals(2, eq.getAcademicClasses().size());
        Assertions.assertTrue(eq.getAcademicClasses().contains(academicClass2));
        Assertions.assertTrue(eq.getAcademicClasses().contains(academicClass));

        Assertions.assertEquals(1,
            academicClassRepository.findAllByNameIgnoreCaseContaining("first").size());
        Assertions.assertEquals(2,
            academicClassRepository.findAllByCodeIgnoreCaseContaining("tttc").size());
        Assertions.assertTrue(courseClassesNumBefore <
                academicClassRepository.findAllByCourse(
                        courseRepository.findById(1L).orElseThrow()).size());

        academicClassManagementService.removeClassesEquivalency(academicClass.getId());
        EquivalentClass eq2 = equivalentClassRepository.findByAcademicClassesContains(academicClass2);

        Assertions.assertEquals(1, eq2.getAcademicClasses().size());
    }
}
