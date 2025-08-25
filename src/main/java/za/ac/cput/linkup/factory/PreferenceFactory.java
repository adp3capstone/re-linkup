package za.ac.cput.linkup.factory;

/* PreferenceFactory.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.enums.Course;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Interest;
import za.ac.cput.linkup.domain.enums.RelationshipType;
import za.ac.cput.linkup.util.Helper;

import java.util.List;

public class PreferenceFactory {
    public static Preference createPreference(Long preferenceId, int minAge, int maxAge, Gender preferredGender,
                                              Course preferredCourses, int maxDistance, boolean smokingPreference,
                                              boolean drinkingPreference, RelationshipType relationshipType,
                                              Interest interests) {

        if (!Helper.isValidLong(preferenceId) ||
                Helper.isIntNegative(minAge) ||
                Helper.isIntNegative(maxAge) ||
                Helper.isObjectNull(preferredGender) ||
                Helper.isObjectNull(preferredCourses) ||
                Helper.isIntNegative(maxDistance) ||
                Helper.isObjectNull(relationshipType) ||
                Helper.isObjectNull(interests)) {
            return null;
        }

        return new Preference.Builder()
                .setPreferenceId(preferenceId)
                .setMinAge(minAge)
                .setMaxAge(maxAge)
                .setPreferredGender(preferredGender)
                .setPreferredCourses(preferredCourses)
                .setMaxDistance(maxDistance)
                .setSmokingPreference(smokingPreference)
                .setDrinkingPreference(drinkingPreference)
                .setRelationshipType(relationshipType)
                .setInterests(interests)
                .build();
    }
}
