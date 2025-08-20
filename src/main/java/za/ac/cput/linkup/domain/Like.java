package za.ac.cput.linkup.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Like {

    @Id
    private long likeId;

    @ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUserId;

    @ManyToOne
    @JoinColumn(name = "to_user_id", nullable = false)
    private User toUserId;
    private LocalDateTime timestamp;

    protected Like() {
    }

    private Like(Builder builder) {
        this.likeId = builder.likeId;
        this.fromUserId = builder.fromUserId;
        this.toUserId = builder.toUserId;
        this.timestamp = builder.timestamp;
    }
    public long getLikeId() {
        return likeId;
    }
    public User getFromUserId() {
        return fromUserId;
    }
    public User getToUserId() {
        return toUserId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class Builder {
        private long likeId;
        private User fromUserId;
        private User toUserId;
        private LocalDateTime timestamp;

        public Builder setLikeId(long likeId) {
            this.likeId = likeId;
            return this;
        }

        public Builder setFromUserId(User fromUserId) {
            this.fromUserId = fromUserId;
            return this;
        }

        public Builder setToUserId(User toUserId) {
            this.toUserId = toUserId;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder copy(Like like) {
            this.likeId = like.likeId;
            this.fromUserId = like.fromUserId;
            this.toUserId = like.toUserId;
            this.timestamp = like.timestamp;
            return this;
        }

        public Like build() {
            return new Like(this);
        }
    }
}
