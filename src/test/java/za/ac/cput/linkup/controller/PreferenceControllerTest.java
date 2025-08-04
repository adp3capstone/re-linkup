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
import za.ac.cput.linkup.domain.enums.Course;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Interest;
import za.ac.cput.linkup.domain.enums.RelationshipType;
import za.ac.cput.linkup.factory.PreferenceFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PreferenceControllerTest {

    private final PreferenceController preferenceController;

    // Sample preference data
    public static Preference preference = PreferenceFactory.createPreference(
            1001L,
            18,
            30,
            Gender.FEMALE,
            List.of(Course.BCOM_IN_FINANCE, Course.BSC_IN_COMPUTER_SCIENCE),
            50,
            true,
            false,
            RelationshipType.FRIENDSHIP,
            List.of(Interest.MUSIC, Interest.MUSIC)
    );

    @Autowired
    PreferenceControllerTest(PreferenceController preferenceController) {
        this.preferenceController = preferenceController;
    }

    @Test
    @Order(1)
    void createPreference() {
        Preference created = preferenceController.createPreference(preference);
        assertNotNull(created);
        System.out.println("Created Preference: " + created);
    }

    @Test
    @Order(2)
    void readBySmokingPreference() {
        Preference found = preferenceController.readBySmokingPreference(preference.isSmokingPreference());
        assertNotNull(found);
        System.out.println("Found Preference (by smoking): " + found);
    }

    @Test
    @Order(3)
    void updatePreference() {
        Preference updated = new Preference.Builder()
                .copy(preference)
                .setRelationshipType(RelationshipType.FRIENDSHIP)
                .build();

        Preference result = preferenceController.updatePreference(updated);
        assertNotNull(result);
        assertEquals(RelationshipType.FRIENDSHIP, result.getRelationshipType());
        System.out.println("Updated Preference: " + result);
    }
}
