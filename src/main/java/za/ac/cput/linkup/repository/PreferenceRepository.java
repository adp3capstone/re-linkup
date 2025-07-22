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

    Optional<Preference> findBySmokingPreference(boolean smokingPreference);
    Optional<Preference> findByDrinkingPreference(boolean drinkingPreference);
    Optional<Preference> findByPreferredGender(String preferredGender);
    Optional<Preference> findByPreferredCourses(List<String> preferredCourses);

    Optional<Preference> findByMinAge(int minAge);
    Optional<Preference> findByMaxAge(int maxAge);

    Optional<Preference> findByMaxDistance(int maxDistance);
    Optional<Preference> findByRelationshipType(String relationshipType);

}
