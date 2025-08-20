package za.ac.cput.linkup.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;
    private LocalDateTime matchedAt;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;

    public Match() {

    }

    private Match(Builder builder) {
        this.matchId = builder.matchId;
        this.matchedAt = builder.matchedAt;
        this.isActive = builder.isActive;
        this.user1 = builder.user1;
        this.user2 = builder.user2;
    }

    public long getMatchId() {
        return matchId;
    }

    public LocalDateTime getMatchedAt() {
        return matchedAt;
    }
    public boolean isActive() {
        return isActive;
    }
    public User getUser1() {
        return user1;
    }
    public User getUser2() {
        return user2;
    }
    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", matchedAt=" + matchedAt +
                ", isActive=" + isActive +
                ", user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }

    public static class Builder {
        private long matchId;
        private LocalDateTime matchedAt;
        private boolean isActive;
        private User user1;
        private User user2;

        public Builder setMatchId(long matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setMatchedAt(LocalDateTime matchedAt) {
            this.matchedAt = matchedAt;
            return this;
        }

        public Builder setActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder setUser1(User user1) {
            this.user1 = user1;
            return this;
        }

        public Builder setUser2(User user2) {
            this.user2 = user2;
            return this;
        }

        public Builder copy(Match match) {
            this.matchId = match.matchId;
            this.matchedAt = match.matchedAt;
            this.isActive = match.isActive;
            this.user1 = match.user1;
            this.user2 = match.user2;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }

}
