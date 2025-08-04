package za.ac.cput.linkup.repository;
/**
 * PreferenceRepository.java
 * Author: Hope Kgomokaboya(222152672)
 * Date: 17/05/2025
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Gender;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

Optional<User> findByUsername(String username);
Optional<User> findByLastName(String lastName);
Optional<User> findByAge(String age);

 Optional<User> findByFirstName(String firstName);

 Optional<User> findByGender(Gender gender);

Optional<User> findByYearOfStudy(String yearOfStudy);
//
}
////