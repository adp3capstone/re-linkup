package za.ac.cput.linkup.service;

/* UserServicejava
Author: SH Kgomokaboya (222152672)
Date: .
*/

import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Gender;

import java.util.Optional;

public interface IUserService extends IService<User,Long>{
    Optional<User> findByUsername(String username);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByAge(String age);

    Optional<User> findByFirstName(String firstName);

    Optional<User> findByGender(Gender gender);

    Optional<User> findByYearOfStudy(String yearOfStudy);
}
