package za.ac.cput.linkup.factory;

import java.time.LocalDateTime;

public class Like {
    public static Like createLike(long matchId,  LocalDateTime matchedAt, User user1, User user2) {
        if (user1 == null || user2 == null || matchedAt == null) {
            return null;
        }

        return new Like.Builder()
                .setMatchId(matchId)
                .setMatchedAt(matchedAt)
                .setUser1(user1)
                .setUser2(user2)
                .build();
    }
}
