package za.ac.cput.linkup.factory;

import za.ac.cput.linkup.domain.*;
import za.ac.cput.linkup.domain.enums.*;
import za.ac.cput.linkup.domain.enums.Institution;
import za.ac.cput.linkup.domain.enums.Major;
import za.ac.cput.linkup.util.Helper;

import java.util.List;

public class UserFactory {

    public static User createUser(Long userId, String username, String password, String email,
                                  String firstName, String lastName, int age, Gender gender,
                                  String bio, List<String> university, List<String> course,
                                  String yearOfStudy, boolean isVerified, Preference preferences,
                                  List<String> likes, List<String> matches, List<String> images) {

        if (userId <= 0 || Helper.isStringNullOrEmpty(username) || Helper.isStringNullOrEmpty(password) ||
                Helper.isStringNullOrEmpty(firstName) || Helper.isStringNullOrEmpty(lastName) || age <= 16 || age > 120 ||
                gender == null || !Helper.isValidEmail(email)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setPassword(password)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setGender(gender)
                .setBio(bio)
                //.setUniversity(university)
                //.setCourse(course)


                .setPreferences(preferences)
                //.setLikes(likes)
                //.setMatches(matches)
                //.setImages(images)
                .build();
    }

    public static User createBasicUser(Long userId, String username, String password,
                                       String email, String firstName, String lastName,
                                       int age, Gender gender) {

        if (userId <= 0 || Helper.isStringNullOrEmpty(username) || Helper.isStringNullOrEmpty(password) ||
                Helper.isStringNullOrEmpty(firstName) || Helper.isStringNullOrEmpty(lastName) || age <= 16 || age > 120 ||
                gender == null || !Helper.isValidEmail(email)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setPassword(password)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)

                .setGender(gender)
                .build();
    }
}
