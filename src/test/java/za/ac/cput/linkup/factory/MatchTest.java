package za.ac.cput.linkup.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Match;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {


    @Test
    void createMatch_success() {

        long matchId = 1001L;
        boolean isActive = true;
        User user1 = new User("u001", "Luyanda");
        User user2 = new User("u002", "Nomusa");
        Match match = Match.createMatch(matchId, LocalDateTime.now(), isActive, user1, user2);

        assertNotNull(match);
        assertEquals(matchId, match.getMatchId());
        assertTrue(match.isActive());
        assertEquals(user1, match.getUser1());
        assertEquals(user2, match.getUser2());
        assertNotNull(match.getMatchedAt());
    }

    @Test
    void createMatch_user1Null_returnsNull() {
        Match match = Match.createMatch(1002L, LocalDateTime.now(), true, null, new User("u002", "Bob"));
        assertNull(match);
    }

    @Test
    void createMatch_user2Null_returnsNull() {
        Match match = Match.createMatch(1003L, LocalDateTime.now(), true, new User("u001", "Alice"), null);
        assertNull(match);
    }
}