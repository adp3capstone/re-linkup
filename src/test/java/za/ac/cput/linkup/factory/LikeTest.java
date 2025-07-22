package za.ac.cput.linkup.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Like;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LikeTest {

    @Test
    void createLike_success() {
        long matchId = 1L;
        LocalDateTime matchedAt = LocalDateTime.now();
        User user1 = new User("u001", "Alice");
        User user2 = new User("u002", "Bob");

        Like like = Like.createLike(matchId, matchedAt, user1, user2);

        assertNotNull(like);
        assertEquals(matchId, like.getMatchId());
        assertEquals(matchedAt, like.getMatchedAt());
        assertEquals(user1, like.getUser1());
        assertEquals(user2, like.getUser2());
    }

    @Test
    void createLike_nullUser1_returnsNull() {
        Like like = Like.createLike(1L, LocalDateTime.now(), null, new User("u002", "Bob"));
        assertNull(like);
    }

    @Test
    void createLike_nullUser2_returnsNull() {
        Like like = Like.createLike(1L, LocalDateTime.now(), new User("u001", "Alice"), null);
        assertNull(like);
    }

    @Test
    void createLike_nullMatchedAt_returnsNull() {
        Like like = Like.createLike(1L, null, new User("u001", "Alice"), new User("u002", "Bob"));
        assertNull(like);
    }
}
