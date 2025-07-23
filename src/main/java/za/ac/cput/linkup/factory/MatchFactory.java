package za.ac.cput.linkup.factory;

import za.ac.cput.linkup.domain.Match;

import java.time.LocalDateTime;

public class MatchFactory {
    public static Match createMatch(long matchId, LocalDateTime matchedAt, boolean isActive, User user1, User user2) {
        if (user1 == null || user2 == null) {
            return null;
        }

        return new Match.Builder()
                .setMatchId(matchId)
                .setMatchedAt(LocalDateTime.now())
                .setActive(isActive)
                .setUser1(user1)
                .setUser2(user2)
                .build();
    }
}
