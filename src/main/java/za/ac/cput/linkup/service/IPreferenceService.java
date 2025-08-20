package za.ac.cput.linkup.service;

/* PreferenceService.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Gender;

import java.util.Optional;

public interface IPreferenceService extends IService <Preference, Long>{
    Optional<Preference> findByPreferenceId(Long preferenceId);

    Optional<Preference> findBySmokingPreference(boolean smokingPreference);

    Optional<Preference> findByDrinkingPreference(boolean drinkingPreference);

    Optional<Preference> findByPreferredGender(String preferredGender);

    Optional<Preference> findByMinAge(int minAge);

    Optional<Preference> findByMaxAge(int maxAge);

    Optional<Preference> findByMaxDistance(int maxDistance);

    Optional<Preference> findByRelationshipType(String relationshipType);
}
