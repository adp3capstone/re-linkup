package za.ac.cput.linkup.factory;

import za.ac.cput.linkup.domain.Gender;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.util.Helper;

import java.util.List;

public class UserFactory {

    public static User createUser(int userId, String username, String password, String email,
                                  String firstName, String lastName, String age, Gender gender,
                                  String bio, List<String> university, List<String> course,
                                  String yearOfStudy, boolean isVerified, Preference preferences,
                                  List<String> likes, List<String> matches, List<String> images) {

        if (userId <= 0 || Helper.isStringNullOrEmpty(username) || Helper.isStringNullOrEmpty(password) ||
                Helper.isStringNullOrEmpty(firstName) ||
                Helper.isStringNullOrEmpty(lastName) || Helper.isStringNullOrEmpty(age) || gender == null) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        try {
            int ageValue = Integer.parseInt(age);
            if (ageValue <= 16 || ageValue > 120) {  // Assuming reasonable age limits
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setGender(gender)
                .setBio(bio)
//                .setUniversity(university)
//                .setCourse(course)
                .setYearOfStudy(yearOfStudy)
                .setVerified(isVerified)
                .setPreferences(preferences)
//                .setLikes(likes)
//                .setMatches(matches)
//                .setImages(images)
                .build();
    }

    public static User createBasicUser(int userId, String username, String password,
                                       String email, String firstName, String lastName,
                                       String age, Gender gender) {

        if (userId <= 0 || Helper.isStringNullOrEmpty(username) || Helper.isStringNullOrEmpty(password)
                || Helper.isStringNullOrEmpty(firstName) ||
                Helper.isStringNullOrEmpty(lastName) || Helper.isStringNullOrEmpty(age) || gender == null) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        try {
            int ageValue = Integer.parseInt(age);
            if (ageValue <= 16 || ageValue > 120) {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setGender(gender)
                .build();
    }
}

