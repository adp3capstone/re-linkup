package za.ac.cput.linkup.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.linkup.domain.Preference;

import java.util.List;
import java.util.Optional;
import java.util.prefs.Preferences;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
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
