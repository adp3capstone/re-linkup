package za.ac.cput.linkup.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MatchFactoryTest {


    @Test
    void createMatch_success() {

        long matchId = 1001L;
        boolean isActive = true;
        User user1 = new User();
        User user2 = new User();
        Match match = MatchFactory.createMatch(matchId, LocalDateTime.now(), isActive, user1, user2);

        assertNotNull(match);
        assertEquals(matchId, match.getMatchId());
        assertTrue(match.isActive());
        assertEquals(user1, match.getUser1());
        assertEquals(user2, match.getUser2());
        assertNotNull(match.getMatchedAt());
    }

    @Test
    void createMatch_user1Null_returnsNull() {
        Match match = MatchFactory.createMatch(1002L, LocalDateTime.now(), true, null, new User());
        assertNull(match);
    }

    @Test
    void createMatch_user2Null_returnsNull() {
        Match match = MatchFactory.createMatch(1003L, LocalDateTime.now(), true, new User(), null);
        assertNull(match);
    }
}