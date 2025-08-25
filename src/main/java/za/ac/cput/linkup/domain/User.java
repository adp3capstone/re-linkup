package za.ac.cput.linkup.domain;

import jakarta.persistence.*;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Institution;
import za.ac.cput.linkup.domain.enums.Major;

import java.util.List;

@Entity
public class User {
    @Id
    private Long userId;
    private String password; //use bcrypt
    private String email;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String bio;
    private Institution institution;
    private Major major;
    @OneToOne
    @JoinColumn(name = "preferenceId")
    private Preference preferences;

    @OneToMany
    private List<Like> likes;


    @OneToMany(mappedBy = "user1")
    private List<Match> matches;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Image> images;

    public User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.bio = builder.bio;
        this.institution = builder.institution;
        this.gender = builder.gender;
        this.major = builder.major;
        this.preferences = builder.preferences;
        this.likes = builder.likes;
        this.matches = builder.matches;
        this.images = builder.images;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBio() {
        return bio;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Major getMajor() {
        return major;
    }

    public Preference getPreferences() {
        return preferences;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", bio='" + bio + '\'' +
                ", institution=" + institution +
                ", major=" + major +
                ", preferences=" + preferences +
                ", likes=" + likes +
                ", matches=" + matches +
                ", images=" + images +
                '}';
    }

    public static class Builder {
        private Long userId;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private int age;
        private Gender gender;
        private String bio;
        private Institution institution;
        private Major major;
        private Preference preferences;
        private List<Like> likes;
        private List<Match> matches;
        private List<Image> images;

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder setInstitution(Institution institution) {
            this.institution = institution;
            return this;
        }

        public Builder setMajor(Major major) {
            this.major = major;
            return this;
        }

        public Builder setPreferences(Preference preferences) {
            this.preferences = preferences;
            return this;
        }

        public Builder setLikes(List<Like> likes) {
            this.likes = likes;
            return this;
        }

        public Builder setMatches(List<Match> matches) {
            this.matches = matches;
            return this;
        }

        public Builder setImages(List<Image> images) {
            this.images = images;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.getUserId();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.age = user.getAge();
            this.gender = user.getGender();
            this.bio = user.getBio();
            this.institution = user.getInstitution();
            this.major = user.getMajor();
            this.preferences = user.getPreferences();
            this.likes = user.getLikes();
            this.matches = user.getMatches();
            this.images = user.getImages();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
