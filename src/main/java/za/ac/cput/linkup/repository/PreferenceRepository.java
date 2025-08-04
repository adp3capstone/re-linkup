package za.ac.cput.linkup.repository;
/**
 * PreferenceRepository.java
 * Author: Hope Kgomokaboya(222152672)
 * Date: 17/05/2025
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.linkup.domain.Preference;


import java.util.Optional;


@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    Optional<Preference> findByPreferenceId(Long preferenceId);

    Optional<Preference> findBySmokingPreference(boolean smokingPreference);

    Optional<Preference> findByDrinkingPreference(boolean drinkingPreference);

    Optional<Preference> findByPreferredGender(String preferredGender);

    Optional<Preference> findByMinAge(int minAge);

    Optional<Preference> findByMaxAge(int maxAge);

    Optional<Preference> findByMaxDistance(int maxDistance);

    Optional<Preference> findByRelationshipType(String relationshipType);
//
}////end of