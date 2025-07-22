package za.ac.cput.linkup.service;

import za.ac.cput.linkup.domain.Gender;
import za.ac.cput.linkup.domain.User;

import java.util.Optional;

public interface IUserService extends IService<User,Integer>{

    Optional<User> findByUsername(String username);

    Optional<User> findByLastName(String lastName);
    Optional<User> findByAge(String age);

    Optional<User> findByFirstName(String firstName);

    Optional<User> findByGender(Gender gender);

    Optional<User> findByYearOfStudy(String yearOfStudy);
}
