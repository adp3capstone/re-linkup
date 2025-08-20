package za.ac.cput.linkup.service;

/* UserService.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public Optional<User> findByAge(String age) {
        return userRepository.findByAge(age);
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<User> findByGender(Gender gender) {
        return userRepository.findByGender(gender);
    }

    @Override
    public Optional<User> findByYearOfStudy(String yearOfStudy) {
        return userRepository.findByYearOfStudy(yearOfStudy);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public User read(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}