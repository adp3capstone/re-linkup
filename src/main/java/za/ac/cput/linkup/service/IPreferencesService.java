package za.ac.cput.linkup.service;

import za.ac.cput.linkup.domain.Preference;

import java.util.List;
import java.util.Optional;
import java.util.prefs.Preferences;

public interface IPreferencesService extends IService<Preferences,Integer>{
    Optional<Preference> findByPreferenceId(int preferenceId);

    Optional<Preferences> findBySmokingPreference(boolean smokingPreference);
    Optional<Preferences> findByDrinkingPreference(boolean drinkingPreference);
    Optional<Preferences> findByPreferredGender(String preferredGender);
    Optional<Preferences> findByPreferredCourses(List<String> preferredCourses);

    Optional<Preferences> findByMinAge(int minAge);
    Optional<Preferences> findByMaxAge(int maxAge);

    Optional<Preferences> findByMaxDistance(int maxDistance);
    Optional<Preference> findByRelationshipType(String relationshipType);
}
