package za.ac.cput.linkup.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LikeFactoryTest {

    @Test
    void createLike_success() {
        long likeId = 1L;
        LocalDateTime timestamp = LocalDateTime.now();
        User fromUser = new User();
        User toUser = new User();

        Like like = LikeFactory.createLike(likeId, fromUser, toUser, timestamp);

        assertNotNull(like);
        assertEquals(likeId, like.getLikeId());
        assertEquals(fromUser, like.getFromUserId());
        assertEquals(toUser, like.getToUserId());
        assertEquals(timestamp, like.getTimestamp());
    }

    @Test
    void createLike_nullFromUser_returnsNull() {
        Like like = LikeFactory.createLike(1L, null, new User(), LocalDateTime.now());
        assertNull(like);
    }

    @Test
    void createLike_nullToUser_returnsNull() {
        Like like = LikeFactory.createLike(1L, new User(), null, LocalDateTime.now());
        assertNull(like);
    }

    @Test
    void createLike_nullTimestamp_returnsNull() {
        Like like = LikeFactory.createLike(1L, new User(), new User(), null);
        assertNull(like);
    }
}
