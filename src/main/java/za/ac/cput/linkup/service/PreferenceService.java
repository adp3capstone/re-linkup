package za.ac.cput.linkup.service;

/* PreferenceService.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.repository.PreferenceRepository;

import java.util.List;
import java.util.Optional;
@Service
public class PreferenceService implements IPreferenceService {
 @Autowired
 private PreferenceRepository preferenceRepository;
 @Autowired
 public PreferenceService(PreferenceRepository preferenceRepository) {
 this.preferenceRepository = preferenceRepository;
 }


 @Override
 public Optional<Preference> findByPreferenceId(Long preferenceId) {
return preferenceRepository.findByPreferenceId(preferenceId);
 }

 @Override
public Optional<Preference> findBySmokingPreference(boolean smokingPreference) {
 return preferenceRepository.findBySmokingPreference(smokingPreference);
 }

@Override
 public Optional<Preference> findByDrinkingPreference(boolean drinkingPreference) {
 return preferenceRepository.findByDrinkingPreference(drinkingPreference);
 }

 @Override
 public Optional<Preference> findByPreferredGender(String preferredGender) {
 return preferenceRepository.findByPreferredGender(preferredGender);
 }



 @Override
 public Optional<Preference> findByMinAge(int minAge) {
return preferenceRepository.findByMinAge(minAge);
 }

 @Override
 public Optional<Preference> findByMaxAge(int maxAge) {
 return preferenceRepository.findByMaxAge(maxAge);
 }

@Override
 public Optional<Preference> findByMaxDistance(int maxDistance) {
 return preferenceRepository.findByMaxDistance(maxDistance);
}

@Override
public Optional<Preference> findByRelationshipType(String relationshipType) {
return preferenceRepository.findByRelationshipType(relationshipType);
 }


 @Override
 public Preference save(Preference entity) {
 return preferenceRepository.save(entity);
}
@Override
public Preference update(Preference entity) {
return preferenceRepository.save(entity);
 }

@Override
public void deleteById(Long aLong) {

}

@Override
public Preference read(Long aLong) {
return null;
}

 @Override
 public List<Preference> findAll() {
return preferenceRepository.findAll();
}
}