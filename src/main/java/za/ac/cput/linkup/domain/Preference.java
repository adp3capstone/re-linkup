package za.ac.cput.linkup.domain;

/* Preference.java
Author: SH Kgomokaboya (222152672)
Date: 11 May 2025.
*/


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity


public class Preference {

    @Id
    private int preferenceId;
    private int minAge;
    private int maxAge;
    private String preferredGender;
//    private List<Course> preferredCourses;
    private int maxDistance;
    private boolean smokingPreference;
    private boolean drinkingPreference;
    private String relationshipType;
//    private List<String> interests;

    public Preference() {}

    private Preference(Builder builder) {
        this.preferenceId = builder.preferenceId;
        this.minAge = builder.minAge;
        this.maxAge = builder.maxAge;
        this.preferredGender = builder.preferredGender;
//        this.preferredCourses = builder.preferredCourses;
        this.maxDistance = builder.maxDistance;
        this.smokingPreference = builder.smokingPreference;
        this.drinkingPreference = builder.drinkingPreference;
        this.relationshipType = builder.relationshipType;
//        this.interests = builder.interests;
}
    public int getPreferenceId() {
        return preferenceId;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public String getPreferredGender() {
        return preferredGender;
    }

//    public List<Course> getPreferredCourses() {
//        return Courses;
//    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public boolean isSmokingPreference() {
        return smokingPreference;
    }

    public boolean isDrinkingPreference() {
        return drinkingPreference;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

//    public List<String> getInterests() {
//        return interests;
//    }
    @Override
    public String toString() {
        return "Preference{" +
                "preferenceId=" + preferenceId +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", preferredGender='" + preferredGender + '\'' +
//                ", preferredCourses=" + preferredCourses +
                ", maxDistance=" + maxDistance +
                ", smokingPreference=" + smokingPreference +
                ", drinkingPreference=" + drinkingPreference +
                ", relationshipType='" + relationshipType + '\'' +
//                ", interests=" + interests +
                '}';
    }

    public static class Builder {
        private int preferenceId;
        private int minAge;
        private int maxAge;
        private String preferredGender;
        private List<String> preferredCourses;
        private int maxDistance;
        private boolean smokingPreference;
        private boolean drinkingPreference;
        private String relationshipType;
        private List<String> interests;

        public Builder setPreferenceId(int preferenceId) {
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

        public Builder setPreferredGender(String preferredGender) {
            this.preferredGender = preferredGender;
            return this;
        }

        public Builder setPreferredCourses(List<String> preferredCourses) {
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

        public Builder setRelationshipType(String relationshipType) {
            this.relationshipType = relationshipType;
            return this;
        }

        public Builder setInterests(List<String> interests) {
            this.interests = interests;
            return this;
        }

        public Builder copy(Preference preference) {
            this.preferenceId = preference.preferenceId;
            this.minAge = preference.minAge;
            this.maxAge = preference.maxAge;
            this.preferredGender = preference.preferredGender;
//            this.preferredCourses = preference.preferredCourses;
            this.maxDistance = preference.maxDistance;
            this.smokingPreference = preference.smokingPreference;
            this.drinkingPreference = preference.drinkingPreference;
            this.relationshipType = preference.relationshipType;
//            this.interests = preference.interests;
            return this;
        }

        public Preference build() {
            return new Preference(this);
        }
    }
}

