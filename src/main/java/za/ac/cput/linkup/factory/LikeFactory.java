package za.ac.cput.linkup.factory;


import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;

import java.time.LocalDateTime;

public class LikeFactory {
    public static Like createLike(long likeId, User fromUser, User toUser, LocalDateTime timestamp) {
        if (fromUser == null || toUser == null || timestamp == null) {
            return null;
        }

        return new Like.Builder()
                .setLikeId(likeId)
                .setFromUserId(fromUser)
                .setToUserId(toUser)
                .setTimestamp(timestamp)
                .build();
    }
}
