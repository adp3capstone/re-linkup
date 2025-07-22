package za.ac.cput.linkup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.repository.PreferenceRepository;

import java.util.List;
import java.util.Optional;
import java.util.prefs.Preferences;

@Service
public class PreferenceService implements IPreferencesService {
    @Autowired
    private PreferenceRepository preferenceRepository;
    @Autowired
    public PreferenceService(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }


    @Override
    public Optional<Preference> findByPreferenceId(int preferenceId) {
        return preferenceRepository.findById(preferenceId);
    }

    @Override
    public Optional<Preferences> findBySmokingPreference(boolean smokingPreference) {
        return preferenceRepository.findBySmokingPreference(smokingPreference);
    }

    @Override
    public Optional<Preferences> findByDrinkingPreference(boolean drinkingPreference) {
        return preferenceRepository.findByDrinkingPreference(drinkingPreference);
    }

    @Override
    public Optional<Preferences> findByPreferredGender(String preferredGender) {
        return preferenceRepository.findByPreferredGender(preferredGender);
    }

    @Override
    public Optional<Preferences> findByPreferredCourses(List<String> preferredCourses) {
        return preferenceRepository.findByPreferredCourses(preferredCourses);
    }

    @Override
    public Optional<Preferences> findByMinAge(int minAge) {
        return preferenceRepository.findByMinAge(minAge);
    }

    @Override
    public Optional<Preferences> findByMaxAge(int maxAge) {
        return preferenceRepository.findByMaxAge(maxAge);
    }

    @Override
    public Optional<Preferences> findByMaxDistance(int maxDistance) {
        return preferenceRepository.findByMaxDistance(maxDistance);
    }

    @Override
    public Optional<Preference> findByRelationshipType(String relationshipType) {
        return preferenceRepository.findByRelationshipType(relationshipType);
    }

    @Override
    public Preferences create(Preferences preferences) {
        return null;
    }

    @Override
    public Preferences read(Integer integer) {
        return null;
    }

    @Override
    public Preferences update(Preferences preferences) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Preferences> findAll() {
        return List.of();
    }
}
