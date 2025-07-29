package za.ac.cput.linkup.factory;

import za.ac.cput.linkup.domain.*;
import za.ac.cput.linkup.domain.enums.*;
import za.ac.cput.linkup.domain.enums.Institution;
import za.ac.cput.linkup.domain.enums.Major;
import za.ac.cput.linkup.util.Helper;

import java.util.List;

public class UserFactory {
    public static User createUser(Long userId, String password, String email, String firstName, String lastName,
                                  int age, Gender gender, String bio, Institution institution, Major major,
                                  Preference preferences, List<Like> likes, List<Match> matches, List<Image> images) {

        if (!Helper.isValidLong(userId) ||
                Helper.isStringNullOrEmpty(password) ||
                !Helper.isValidEmail(email) ||
                Helper.isStringNullOrEmpty(firstName) ||
                Helper.isStringNullOrEmpty(lastName) ||
                Helper.isIntNegative(age) ||
                Helper.isObjectNull(gender) ||
                Helper.isObjectNull(institution) ||
                Helper.isObjectNull(major)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setPassword(password)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setGender(gender)
                .setBio(bio)
                .setInstitution(institution)
                .setMajor(major)
                .setPreferences(preferences)
                .setLikes((List) likes)
                .setMatches((List) matches)
                .setImages((List) images)
                .build();
    }
}
