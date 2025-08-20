package za.ac.cput.linkup.service;

/* UserServiceTest.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.factory.PreferenceFactory;
import za.ac.cput.linkup.factory.UserFactory;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private static Preference preference = PreferenceFactory.createPreference(
            1L, 18, 30, Gender.FEMALE, null, 50, true, false, null, null);


    private static User user = UserFactory.createUser(
            1L,
            "lee123",
            "pass123",
            "lee@example.com",
            "Lee",
            "Smith",
            23,
            Gender.FEMALE,
            "Lite bio",
            null,
            null,
            "3rd Year",
            true,
            preference,
            null,
            null,
            null
    );

    private static User savedUser;

    @Test
    @Order(1)
    void testCreateUser() {
        savedUser = userService.save(user);
        assertNotNull(savedUser);
        System.out.println("Created user: " + savedUser);
    }

    @Test
    @Order(2)
    void testReadUser() {
        assertNotNull(savedUser);
        User read = userService.read(savedUser.getUserId());
        assertNotNull(read);
        assertEquals(savedUser.getUserId(), read.getUserId());
        System.out.println("Read user: " + read);
    }

    @Test
    @Order(3)
    void testUpdateUser() {
        User updatedUser = new User.Builder()
                .copy(savedUser)
                .setBio("Updated bio - I love AI and tech!")
                .build();

        User result = userService.update(updatedUser);
        assertNotNull(result);
        assertEquals("Updated bio - I love AI and tech!", result.getBio());
        System.out.println("Updated user: " + result);

        savedUser = result;
    }

    @Test
    @Order(4)
    void testDeleteUser() {
        assertNotNull(savedUser);
        userService.deleteById(savedUser.getUserId());

        User deleted = userService.read(savedUser.getUserId());
        assertNull(deleted);
        System.out.println("Deleted user with ID: " + savedUser.getUserId());
    }
}