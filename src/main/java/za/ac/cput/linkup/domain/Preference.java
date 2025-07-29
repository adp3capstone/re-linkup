package za.ac.cput.linkup.domain;

import za.ac.cput.linkup.domain.enums.Course;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Interest;
import za.ac.cput.linkup.domain.enums.RelationshipType;

import java.util.List;

public class Preference {
    private Long preferenceId;
    private int minAge;
    private int maxAge;
    private Gender preferredGender;
    private List<Course> preferredCourses;
    private int maxDistance;
    private boolean smokingPreference;
    private boolean drinkingPreference;
    private RelationshipType relationshipType;
    private List<Interest> interests;

    public Preference() {
    }

    private Preference(Builder builder) {
        this.preferenceId = builder.preferenceId;
        this.minAge = builder.minAge;
        this.maxAge = builder.maxAge;
        this.preferredGender = builder.preferredGender;
        this.preferredCourses = builder.preferredCourses;
        this.maxDistance = builder.maxDistance;
        this.smokingPreference = builder.smokingPreference;
        this.drinkingPreference = builder.drinkingPreference;
        this.relationshipType = builder.relationshipType;
        this.interests = builder.interests;
    }

    public static class Builder {
        private Long preferenceId;
        private int minAge;
        private int maxAge;
        private Gender preferredGender;
        private List<Course> preferredCourses;
        private int maxDistance;
        private boolean smokingPreference;
        private boolean drinkingPreference;
        private RelationshipType relationshipType;
        private List<Interest> interests;

        public Builder setPreferenceId(Long preferenceId) {
            this.preferenceId = preferenceId;
            return this;
        }

        public Builder setMinAge(int minAge) {
            this.minAge = minAge;
            return this;
        }

        public Builder setMaxAge(int maxAge) {
            this.maxAge = maxAge;
            return this;
        }

        public Builder setPreferredGender(Gender preferredGender) {
            this.preferredGender = preferredGender;
            return this;
        }

        public Builder setPreferredCourses(List<Course> preferredCourses) {
            this.preferredCourses = preferredCourses;
            return this;
        }

        public Builder setMaxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        public Builder setSmokingPreference(boolean smokingPreference) {
            this.smokingPreference = smokingPreference;
            return this;
        }

        public Builder setDrinkingPreference(boolean drinkingPreference) {
            this.drinkingPreference = drinkingPreference;
            return this;
        }

        public Builder setRelationshipType(RelationshipType relationshipType) {
            this.relationshipType = relationshipType;
            return this;
        }

        public Builder setInterests(List<Interest> interests) {
            this.interests = interests;
            return this;
        }

        public Builder copy(Preference preference) {
            this.preferenceId = preference.preferenceId;
            this.minAge = preference.minAge;
            this.maxAge = preference.maxAge;
            this.preferredGender = preference.preferredGender;
            this.preferredCourses = preference.preferredCourses;
            this.maxDistance = preference.maxDistance;
            this.smokingPreference = preference.smokingPreference;
            this.drinkingPreference = preference.drinkingPreference;
            this.relationshipType = preference.relationshipType;
            this.interests = preference.interests;
            return this;
        }

        public Preference build() {
            return new Preference(this);
        }
    }
}
