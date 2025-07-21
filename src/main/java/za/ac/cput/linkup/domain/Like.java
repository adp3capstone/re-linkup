package za.ac.cput.linkup.domain;

import java.time.LocalDateTime;

public class Like {
    private long matchId;
    private LocalDateTime matchedAt;
    private User user1;
    private User user2;

    private Like() {
    }

    private Like(Builder builder) {
        this.matchId = builder.matchId;
        this.matchedAt = builder.matchedAt;
        this.user1 = builder.user1;
        this.user2 = builder.user2;
    }

    public long getMatchId() {
        return matchId;
    }
    public LocalDateTime getMatchedAt() {
        return matchedAt;
    }
    public User getUser1() {
        return user1;
    }
    public User getUser2() {
        return user2;
    }
    @Override
    public String toString() {
        return "Like{" +
                "matchId=" + matchId +
                ", matchedAt=" + matchedAt +
                ", user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }

    public static class Builder {
        private long matchId;
        private LocalDateTime matchedAt;
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

        public Builder setUser1(User user1) {
            this.user1 = user1;
            return this;
        }

        public Builder setUser2(User user2) {
            this.user2 = user2;
            return this;
        }
        public Builder copy(Like like) {
            this.matchId = like.matchId;
            this.matchedAt = like.matchedAt;
            this.user1 = like.user1;
            this.user2 = like.user2;
            return this;
        }

        public Like build() {
            return new Like(this);
        }
    }
}
