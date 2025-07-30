package za.ac.cput.linkup.factory;

import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.util.Helper;

import java.time.LocalDateTime;

public class LikeFactory {
    public static Like createLike(long likeId, User fromUserId, User toUserId, LocalDateTime timestamp) {
        if (!Helper.isValidLong(likeId) ||
                Helper.isObjectNull(fromUserId) ||
                Helper.isObjectNull(toUserId) ||
                Helper.isDateNull(timestamp)) {
            return null;
        }

        return new Like.Builder()
                .setLikeId(likeId)
                .setFromUserId(fromUserId)
                .setToUserId(toUserId)
                .setTimestamp(timestamp)
                .build();
    }
}
