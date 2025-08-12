package za.ac.cput.linkup.controller;
/* ControllerTest.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Course;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Interest;
import za.ac.cput.linkup.domain.enums.RelationshipType;
import za.ac.cput.linkup.factory.PreferenceFactory;
import za.ac.cput.linkup.factory.UserFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private UserController userController;

    private static final Preference preference = PreferenceFactory.createPreference(
            2001L,
            20,
            30,
            Gender.FEMALE,
            List.of(Course.BCOM_IN_FINANCE),
            10,
            true,
            false,
            RelationshipType.FRIENDSHIP,
            List.of(Interest.MUSIC)
    );

    private static final User user = UserFactory.createUser(
            3001L,
            "jdoe",
            "pass1234",
            "jdoe@example.com",
            "John",
            "Doe",
            22,
            Gender.MALE,
            "I love hiking.",
            List.of("Cape Peninsula University"),
            List.of("Computer Science"),
            "2nd",
            true,
            preference,
            List.of(),
            List.of(),
            List.of()
    );

    @Test
    @Order(1)
    void createUser() {
        User created = userController.createUser(user);
        assertNotNull(created);
        assertEquals("John", created.getFirstName());
        System.out.println("Created User: " + created);
    }

    @Test
    @Order(2)
    void readUserByName() {
        User found = userController.readUser(user.getFirstName());
        assertNotNull(found);
        assertEquals(user.getFirstName(), found.getFirstName());
        System.out.println("Read User: " + found);
    }

    @Test
    @Order(3)
    void updateUser() {
        User updatedUser = new User.Builder()
                .copy(user)
                .setBio("Updated bio for John.")
                .build();

        User result = userController.updateUser(updatedUser);
        assertNotNull(result);
        assertEquals("Updated bio for John.", result.getBio());
        System.out.println("Updated User: " + result);
    }
}
