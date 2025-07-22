package za.ac.cput.linkup.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Gender;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {


    private static User user = UserFactory.createUser(
            1,
            "testUser",
            "password123",
            "test@example.com",
            "John",
            "Doe",
            "25",
            Gender.MALE,
            "This is a bio",
            new ArrayList<>(),
            new ArrayList<>(),
            "3",
            true,
            new Preference(),
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
    );

    @Test
    void createUser() {
        assertNotNull(user);
        assertEquals(1, user.getUserId());
        assertEquals("testUser", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("25", user.getAge());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals("This is a bio", user.getBio());
        assertEquals("3", user.getYearOfStudy());
        assertTrue(user.isVerified());
        assertNotNull(user.getPreferences());
        System.out.println(user);
    }
}
