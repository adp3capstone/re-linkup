package za.ac.cput.linkup.domain;

/**
 * User.java
 * Author: Hope Kgomokaboya(222152672)
 * Date: 11/05/2025.
 */

import jakarta.persistence.*;

import java.util.List;

@Entity

public class User {

    @Id
    private int userId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String age;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String bio;
//    private List<University> university;
//    private List<Course> course;
    private String yearOfStudy;
    private boolean isVerified;

    @OneToOne
    @JoinColumn(name="preferenceid")
    private Preference preferences;

//    private List<Likes> likes;
//    private List<Match> matches;
//    private List<Images> images;



    private User(Builder builder) {
        this.userId      = builder.userId;
        this.username    = builder.username;
        this.password    = builder.password;
        this.email       = builder.email;
        this.firstName   = builder.firstName;
        this.lastName    = builder.lastName;
        this.age         = builder.age;
        this.gender      = builder.gender;
        this.bio         = builder.bio;
//        this.university  = builder.university;
//        this.course      = builder.course;
        this.yearOfStudy = builder.yearOfStudy;
        this.isVerified  = builder.isVerified;
        this.preferences = builder.preferences;
//        this.likes       = builder.likes;
//        this.matches     = builder.matches;
//        this.images      = builder.images;
    }

    public User() {

    }

    public int getUserId()               { return userId; }
    public String getUsername()          { return username; }
    public String getPassword()          { return password; }
    public String getEmail()             { return email; }
    public String getFirstName()         { return firstName; }
    public String getLastName()          { return lastName; }
    public String getAge()               { return age; }
    public Gender getGender()            { return gender; }
    public String getBio()               { return bio; }
//    public List<University> getUniversity()  { return university; }
//    public List<Course> getCourse()      { return course; }
    public String getYearOfStudy()       { return yearOfStudy; }
    public boolean isVerified()          { return isVerified; }
    public Preference getPreferences()   { return preferences; }
//    public List<String> getLikes()       { return likes; }
//    public List<String> getMatches()     { return matches; }
//    public List<String> getImages()      { return images; }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", bio='" + bio + '\'' +
//                ", university=" + university +
//                ", course=" + course +
                ", yearOfStudy='" + yearOfStudy + '\'' +
                ", isVerified=" + isVerified +
                ", preferences=" + preferences +
//                ", likes=" + likes +
//                ", matches=" + matches +
//                ", images=" + images +
                '}';
    }

    public static class Builder {
        private int userId;
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String age;
        private Gender gender;
        private String bio;
//        private List<University> university;
//        private List<Course> course;
        private String yearOfStudy;
        private boolean isVerified;
        private Preference preferences;
//        private List<Likes> likes;
//        private List<Match> matches;
//        private List<Images> images;

        public Builder setUserId(int userId)                   { this.userId = userId; return this; }
        public Builder setUsername(String username)            { this.username = username; return this; }
        public Builder setPassword(String password)            { this.password = password; return this; }
        public Builder setEmail(String email)                  { this.email = email; return this; }
        public Builder setFirstName(String firstName)          { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName)            { this.lastName = lastName; return this; }
        public Builder setAge(String age)                      { this.age = age; return this; }
        public Builder setGender(Gender gender)                { this.gender = gender; return this; }
        public Builder setBio(String bio)                      { this.bio = bio; return this; }
//        public Builder setUniversity(List<University> university)  { this.university = university; return this; }
//        public Builder setCourse(List<Course> course)          { this.course = course; return this; }
        public Builder setYearOfStudy(String yearOfStudy)      { this.yearOfStudy = yearOfStudy; return this; }
        public Builder setVerified(boolean verified)           { this.isVerified = verified; return this; }
        public Builder setPreferences(Preference preferences)  { this.preferences = preferences; return this; }
//        public Builder setLikes(List<Likes> likes)            { this.likes = likes; return this; }
//        public Builder setMatches(List<Match> matches)        { this.matches = matches; return this; }
//        public Builder setImages(List<Images> images)          { this.images = images; return this; }

        public Builder copy(User user) {
            this.userId      = user.userId;
            this.username    = user.username;
            this.password    = user.password;
            this.email       = user.email;
            this.firstName   = user.firstName;
            this.lastName    = user.lastName;
            this.age         = user.age;
            this.gender      = user.gender;
            this.bio         = user.bio;
//            this.university  = user.university;
//            this.course      = user.course;
            this.yearOfStudy = user.yearOfStudy;
            this.isVerified  = user.isVerified;
            this.preferences = user.preferences;
//            this.likes       = user.likes;
//            this.matches     = user.matches;
//            this.images      = user.images;
            return this;
        }
        public static Builder builder() {
            return new Builder();
}
        public User build() {
            return new User(this);
        }
    }
}
