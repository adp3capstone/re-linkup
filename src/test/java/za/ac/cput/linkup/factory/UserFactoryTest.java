package za.ac.cput.linkup.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {


    @Test
    void createUser() {
        User user = UserFactory.createUser(
                1L,
                "password123",
                "test@example.com",
                "John",
                "Doe",
                25,
                Gender.MALE,
                "Bio",
                Institution.UNIVERSITY_OF_CAPE_TOWN,
                Major.COMPUTER_SCIENCE,
                null,
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertNotNull(user);

        User invalidUser = UserFactory.createUser(
                null,
                "password123",
                "test@example.com",
                "John",
                "Doe",
                25,
                Gender.MALE,
                "Bio",
                Institution.UNIVERSITY_OF_CAPE_TOWN,
                Major.COMPUTER_SCIENCE,
                null,
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertNull(invalidUser);
    }
}