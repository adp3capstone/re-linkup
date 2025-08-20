package za.ac.cput.linkup.service;

/* PreferenceServiceTest.java
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
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.RelationshipType;
import za.ac.cput.linkup.factory.PreferenceFactory;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PreferenceServiceTest {

    @Autowired
    private PreferenceService preferenceService;

    private static Preference savedPreference;

    private final Preference preference = PreferenceFactory.createPreference(
            1L,
            18,
            30,
            Gender.FEMALE,
            new ArrayList<>(),
            50,
            true,
            false,
            RelationshipType.OPEN_RELATIONSHIP,
            new ArrayList<>()
    );

    @Test
    @Order(1)
    void createPreference() {
        savedPreference = preferenceService.save(preference);
        assertNotNull(savedPreference);
        System.out.println("Created: " + savedPreference);
    }

    @Test
    @Order(2)
    void readPreference() {

        assertNotNull(savedPreference, "savedPreference is null. 'createPreference' might have failed.");

        Preference read = preferenceService.read(savedPreference.getPreferenceId());
        assertNotNull(read, "Read preference returned null.");
        assertEquals(savedPreference.getPreferenceId(), read.getPreferenceId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void updatePreference() {
        assertNotNull(savedPreference, "Cannot update a null preference.");

        Preference updated = new Preference.Builder()
                .copy(savedPreference)
                .setRelationshipType(RelationshipType.OPEN_RELATIONSHIP)
                .build();

        Preference result = preferenceService.update(updated);
        assertNotNull(result);
        assertEquals("Serious", result.getRelationshipType());
        savedPreference = result;
        System.out.println(" Updated: " + result);
    }

    @Test
    @Order(4)
    void findByPreferredGender() {
        Optional<Preference> found = preferenceService.findByPreferredGender("Female");
        assertTrue(found.isPresent(), "No preference found with gender 'Female'");
        System.out.println(" Found by gender: " + found.get());
    }

    @Test
    @Order(5)
    void deletePreference() {
        assertNotNull(savedPreference, "No preference to delete");

        preferenceService.deleteById(savedPreference.getPreferenceId());

        Preference deleted = preferenceService.read(savedPreference.getPreferenceId());
        assertNull(deleted, "Preference should be deleted but was found.");
        System.out.println("Deleted preference with ID: " + savedPreference.getPreferenceId());
    }
}