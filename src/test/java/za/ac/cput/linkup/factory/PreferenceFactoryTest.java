package za.ac.cput.linkup.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Preference;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreferenceFactoryTest {
    private static List<String> courses = new ArrayList<>();
    private static List<String> interests = new ArrayList<>();

    private static Preference preference = PreferenceFactory.createPreference(
            1,
            18,
            30,
            "Female",
            courses,
            50,
            true,
            false,
            "Casual",
            interests
    );

    @Test
    void createPreference() {
        assertNotNull(preference);
        assertEquals(1, preference.getPreferenceId());
        assertEquals(18, preference.getMinAge());
        assertEquals(30, preference.getMaxAge());
        assertEquals("Female", preference.getPreferredGender());
        assertEquals(50, preference.getMaxDistance());
        assertTrue(preference.isSmokingPreference());
        assertFalse(preference.isDrinkingPreference());
        assertEquals("Casual", preference.getRelationshipType());
//        assertNotNull(preference.getPreferredCourses());
//        assertNotNull(preference.getInterests());

        System.out.println(preference);
    }

}