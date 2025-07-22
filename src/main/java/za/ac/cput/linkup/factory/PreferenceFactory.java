package za.ac.cput.linkup.factory;

/**
 * PreferenceFactory.java
 * Author: Hope Kgomokaboya(222152672)
 * Date: 17/05/2025
 */

import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.util.Helper;

import java.util.List;

public class PreferenceFactory {

    public static Preference createPreference(int preferenceId, int minAge, int maxAge,
                                              String preferredGender, List<String> preferredCourses,
                                              int maxDistance, boolean smokingPreference,
                                              boolean drinkingPreference, String relationshipType,
                                              List<String> interests) {

        if (preferenceId <= 0 || minAge <= 0 || maxAge <= 0 || maxDistance <= 0) {
            return null;
        }

        if (minAge > maxAge) {
            return null;
        }

        if (Helper.isStringNullOrEmpty(preferredGender)) {
            return null;
        }

        if (Helper.isStringNullOrEmpty(relationshipType)) {
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

    public static Preference createBasicPreference(int preferenceId, int minAge, int maxAge,
                                                   String preferredGender) {

        if (preferenceId <= 0 || minAge <= 0 || maxAge <= 0) {
            return null;
        }

        if (minAge > maxAge) {
            return null;
        }

        if (Helper.isStringNullOrEmpty(preferredGender)) {
            return null;
        }

        return new Preference.Builder()
                .setPreferenceId(preferenceId)
                .setMinAge(minAge)
                .setMaxAge(maxAge)
                .setPreferredGender(preferredGender)
                .build();
    }
}

