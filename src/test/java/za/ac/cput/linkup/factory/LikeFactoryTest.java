package za.ac.cput.linkup.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LikeFactoryTest {

    @Test
    void createLike_success() {
        long matchId = 1L;
        LocalDateTime matchedAt = LocalDateTime.now();
        User user1 = new User();
        User user2 = new User();

        Like like = LikeFactory.createLike(matchId, matchedAt, user1, user2);

        assertNotNull(like);
        assertEquals(matchId, like.getMatchId());
        assertEquals(matchedAt, like.getMatchedAt());
        assertEquals(user1, like.getUser1());
        assertEquals(user2, like.getUser2());
    }

    @Test
    void createLike_nullUser1_returnsNull() {
        Like like = LikeFactory.createLike(1L, LocalDateTime.now(), null, new User());
        assertNull(like);
    }

    @Test
    void createLike_nullUser2_returnsNull() {
        Like like = LikeFactory.createLike(1L, LocalDateTime.now(), new User(), null);
        assertNull(like);
    }

    @Test
    void createLike_nullMatchedAt_returnsNull() {
        Like like = LikeFactory.createLike(1L, null, new User(), new User());
        assertNull(like);
    }
}
