package za.ac.cput.linkup.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.enums.Course;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Interest;
import za.ac.cput.linkup.domain.enums.RelationshipType;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PreferenceFactoryTest {

    @Test
    void createPreference() {
        Preference preference = PreferenceFactory.createPreference(
                1L,
                18,
                30,
                Gender.FEMALE,
                Collections.singletonList(Course.BSC_IN_COMPUTER_SCIENCE),
                50,
                false,
                true,
                RelationshipType.FRIENDSHIP,
                Collections.singletonList(Interest.SPORTS)
        );
        assertNotNull(preference);

        Preference invalidPreference = PreferenceFactory.createPreference(
                null,
                18,
                30,
                Gender.FEMALE,
                Collections.singletonList(Course.BSC_IN_COMPUTER_SCIENCE),
                50,
                false,
                true,
                RelationshipType.FRIENDSHIP,
                Collections.singletonList(Interest.SPORTS)
        );
        assertNull(invalidPreference);
    }
}